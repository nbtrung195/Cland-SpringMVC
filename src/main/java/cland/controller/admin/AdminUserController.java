package cland.controller.admin;

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

import cland.model.user;
import cland.service.UserService;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("index")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		model.addAttribute("ListUser", userService.ListUser());
		return "index.user.admin";
	}
	
	@GetMapping("add")
	public String add(HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		return "add.user.admin";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("error") user user, BindingResult rs, RedirectAttributes re) {
		if(rs.hasErrors()) {
			return "add.user.admin";
		}
		if(userService.ExistedUser(user) != null) {
			re.addFlashAttribute("msg", "Tên đăng nhập đã tồn tại");
			return "redirect:/admin/user/add";
		}
		if(userService.addUser(user)>0) {
			re.addFlashAttribute("msg", "Thêm thành công");
			return "redirect:/admin/user/index";
		}
		re.addFlashAttribute("msg", "Thêm thất bại");
		return "redirect:/admin/user/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(HttpSession session, @PathVariable("id") int id, RedirectAttributes re, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		user user = new user();
		user.setId(id);
		if(userService.selectUserById(user)==null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/user/index";
		}
		model.addAttribute("user", userService.selectUserById(user));
		return "edit.user.admin";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("error") user user, BindingResult rs, RedirectAttributes re, Model model) {
		if(rs.hasErrors()) {
			model.addAttribute("user", user);
			return "edit.user.admin";
		}
		if(userService.ExistedUser(user) != null) {
			re.addFlashAttribute("msg", "Tên đăng nhập đã tồn tại");
			return "redirect:/admin/user/edit/{id}";
		}
		if(userService.EditUser(user)>0) {
			re.addFlashAttribute("msg", "Sửa thành công");
			return "redirect:/admin/user/index";
		}
		re.addFlashAttribute("msg", "Sửa thất bại");
		return "redirect:/admin/user/index";
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") int id, RedirectAttributes re, HttpSession session) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		user user = new user();
		user.setId(id);
		if(userService.selectUserById(user)==null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/user/index";
		}
		if(userService.delUser(user)>0) {
			re.addFlashAttribute("msg", "Xóa thành công");
			return "redirect:/admin/user/index";
		}
		re.addFlashAttribute("msg", "Xóa thất bại");
		return "redirect:/admin/user/index";
	}
	
}
