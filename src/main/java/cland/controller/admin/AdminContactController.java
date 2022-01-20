package cland.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cland.model.contact;
import cland.service.ContactService;

@Controller
@RequestMapping("admin/contact")
public class AdminContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("index")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		model.addAttribute("contact", contactService.ListContact());
		return "index.contact.admin";
	}
	
	@GetMapping("/del/{cid}")
	public String del(@PathVariable("cid") int cid, RedirectAttributes re, HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		contact contact = new contact();
		contact.setCid(cid);
		if(contactService.gettContactById(contact) == null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/contact/index";
		}
		if(contactService.delContact(contact)>0) {
			re.addFlashAttribute("msg", "Xóa thành công");
			return "redirect:/admin/contact/index";
		}
		re.addFlashAttribute("msg", "Xóa thất bại");
		return "redirect:/admin/contact/index";
	}
	
}
