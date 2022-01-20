package cland.controller.publics;

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

import cland.model.contact;
import cland.model.land;
import cland.service.CatService;
import cland.service.ContactService;
import cland.service.LandService;

@Controller
@RequestMapping("public")
public class PublicIndexController {
	
	@Autowired
	private CatService catService;
	
	@Autowired 
	private LandService landService;
	
	@Autowired
	private ContactService contactService;
	
	@ModelAttribute
	public void general(Model model) {
		model.addAttribute("listCat", catService.ListCat());
		model.addAttribute("TopLand", landService.TopLand());
	}

	@GetMapping("index/{CurrentPage}")
	public String index(@PathVariable("CurrentPage") int CurrentPage, Model model) {
		int NumberOfLands = landService.ListLand().size();
		int NumberOfPages = (int)Math.ceil((float)NumberOfLands/3); 
		int offset = (CurrentPage-1)*3;
		if(CurrentPage<=0 || CurrentPage>NumberOfPages) {
			return "redirect:/public/index/1";
		}
		model.addAttribute("ListLand", landService.LandPerPage(offset));
		model.addAttribute("CurrentPage", CurrentPage);
		model.addAttribute("NumberOfPages", NumberOfPages);
		return "index.public";
	}
	
	@GetMapping("cat/{cid}/{CurrentPage}")
	public String cat(@PathVariable("cid") int cid,@PathVariable("CurrentPage") int CurrentPage, Model model) {
		int NumberOfLands = landService.selectLandByIdCat(cid).size();
		if(NumberOfLands == 0) {
			model.addAttribute("msg", "Không có bài viết nào");
			return "cat.public";
		}
		int NumberOfPages = (int)Math.ceil((float)NumberOfLands/4);
		if(CurrentPage<1 || CurrentPage>NumberOfPages) {
			return "redirect:/public/cat/{cid}/1";
		}
		int offset = (CurrentPage-1)*4;
		model.addAttribute("ListLand", landService.selectLandByIdCatLimit(cid, offset));
		model.addAttribute("NumberOfPages", NumberOfPages);
		model.addAttribute("CurrentPage", CurrentPage);
		model.addAttribute("cid", cid);
		model.addAttribute("msg", "Bài viết");
		return "cat.public";
	}
	
	@GetMapping("detail/{lid}")
	public String detail(@PathVariable("lid") int lid, Model model, HttpSession session) {
		land land = new land();
		land.setLid(lid);
		land = landService.selectLandById(land);
		if(land == null) {
			return "redirect:/public/index/1";
		}
		if(session.getAttribute("view" + land.getLid())==null) {
			session.setAttribute("view" + land.getLid(), "view" + land.getLid());
			session.setMaxInactiveInterval(300);
			landService.IncreaseView(land);
		}
		model.addAttribute("land", land);
		model.addAttribute("relative", landService.selectRelativeLand(land));
		return "detail.public";
	}
	
	@GetMapping("contact")
	public String Contact() {
		return "contact.public";
	}
	
	@PostMapping("contact")
	public String Contact(@Valid @ModelAttribute("error") contact contact, BindingResult rs, RedirectAttributes re) {
		if(rs.hasErrors()) {
			return "contact.public";
		}
		if(contactService.addContact(contact)>0) {
			re.addFlashAttribute("msg", "Gửi liên hệ thành công");
			return "redirect:/public/contact";
		}
		re.addFlashAttribute("msg", "Gửi liên hệ thất bại");
		return "redirect:/public/contact";
	}
	
	@GetMapping("search")
	public String search(@ModelAttribute() land search, Model model) {
		model.addAttribute("ListLand", landService.searchLand(search));
		model.addAttribute("msg", landService.searchLand(search).size());
		return "search.public";
	}
	
}
