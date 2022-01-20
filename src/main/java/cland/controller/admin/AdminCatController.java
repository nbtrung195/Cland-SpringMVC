package cland.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cland.model.cat;
import cland.service.CatService;

@Controller
@RequestMapping("admin/cat")
public class AdminCatController {
	
	@Autowired
	private CatService catService;

	@GetMapping("index")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		List<cat> ListCat = catService.ListCat();
		model.addAttribute("ListCat", ListCat);
		return "index.cat.admin";
	}
	
	@GetMapping("add")
	public String add(HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		return "add.cat.admin";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("error") cat Cat, BindingResult rs, RedirectAttributes re) {
		if(rs.hasErrors()) {
			return "add.cat.admin";
		}
		if(catService.ExistedCat(Cat) != null) {
			re.addFlashAttribute("msg", "Tên danh mục đã tồn tại");
			return "redirect:/admin/cat/add";
		}
		if(catService.addCat(Cat)>0) {
			re.addFlashAttribute("msg", "Thêm thành công");
			return "redirect:/admin/cat/index";
		}
		re.addFlashAttribute("msg", "Thêm thất bại");
		return "redirect:/admin/cat/index";
	}
	
	@GetMapping("edit/{cid}")
	public String edit(@PathVariable("cid") int cid,HttpSession session, Model model, RedirectAttributes re) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		cat cat = new cat();
		cat.setCid(cid);
		if(catService.getCatById(cat) == null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/cat/index";
		}
		model.addAttribute("cat", catService.getCatById(cat));
		return "edit.cat.admin";
	}
	
	@PostMapping("edit/{cid}")
	public String edit(@Valid @ModelAttribute("error") cat cat,BindingResult rs, RedirectAttributes re, Model model) {
		if(rs.hasErrors()) {
			model.addAttribute("cat", cat);
			return "edit.cat.admin";
		}
		if(catService.ExistedCat(cat) != null) {
			re.addFlashAttribute("msg", "Tên danh mục đã tồn tại");
			return "redirect:/admin/cat/edit/{cid}";
		}
		if(catService.editCat(cat)>0) {
			re.addFlashAttribute("msg", "Sửa thành công");
			return "redirect:/admin/cat/index";
		}
		re.addFlashAttribute("msg", "Sửa thất bại");
		return "redirect:/admin/cat/index";
	}
	
	@GetMapping("del/{cid}")
	public String del(@PathVariable("cid") int cid, RedirectAttributes re) {
		cat cat = new cat();
		cat.setCid(cid);
		if(catService.getCatById(cat) == null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/cat/index";
		}
		if(catService.delCat(cat)>0) {
			re.addFlashAttribute("msg", "Xóa thành công");
			return "redirect:/admin/cat/index";
		}
		re.addFlashAttribute("msg", "Xóa thất bại");
		return "redirect:/admin/cat/index";
	}
	
}








