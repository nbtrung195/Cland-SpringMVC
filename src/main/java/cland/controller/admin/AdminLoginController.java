package cland.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cland.model.user;
import cland.service.UserService;

@Controller
@RequestMapping("login")
public class AdminLoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("")
	public String login(HttpSession session) {
		if(session.getAttribute("session")!=null) {
			return "redirect:/admin/home";
		}
		return "login";
	}
	
	@PostMapping("")
	public String login(@ModelAttribute user User, HttpSession session, RedirectAttributes re) {
		if(userService.login(User)==null) {
			re.addFlashAttribute("msg", "Sai tên đăng nhập hoặc mật khẩu");
			return "redirect:/login";
		}
		session.setAttribute("session", User);
		return "redirect:/admin/home";
	}
	
}
