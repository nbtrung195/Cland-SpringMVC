package cland.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cland.model.cat;
import cland.model.contact;
import cland.model.land;
import cland.model.user;
import cland.service.CatService;
import cland.service.ContactService;
import cland.service.LandService;
import cland.service.UserService;

@Controller
@RequestMapping("admin/home")
public class AdminIndexController {
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		List<cat> ListCat = catService.ListCat();
		List<user> ListUser = userService.ListUser();
		List<land> ListLand = landService.ListLand();
		List<contact> ListContact = contactService.ListContact();
		int listcat = ListCat.size();
		int listuser = ListUser.size();
		int listland = ListLand.size();
		int listcontact = ListContact.size();
		model.addAttribute("listcat", listcat);
		model.addAttribute("listuser", listuser);
		model.addAttribute("listland", listland);
		model.addAttribute("listcontact", listcontact);
		return "home.admin";
	}
	
}
