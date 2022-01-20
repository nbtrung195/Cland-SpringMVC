package cland.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cland.constant.PictureValidator;
import cland.model.land;
import cland.service.CatService;
import cland.service.LandService;

@Controller
@RequestMapping("admin/land")
public class AdminLandController {
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CatService catService;

	@GetMapping("index")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		model.addAttribute("ListLand", landService.ListLand());
		return "index.land.admin";
	}
	
	@GetMapping("add")
	public String add(HttpSession session, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		model.addAttribute("listcat", catService.ListCat());
		return "add.land.admin";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("error") land land, BindingResult rs, HttpServletRequest request,
			          @RequestParam("hinhanh") MultipartFile multipartfile, RedirectAttributes re, Model model) {
		String fileName = multipartfile.getOriginalFilename();
		PictureValidator pictureValidator = new PictureValidator();
		pictureValidator.validate(fileName, rs);
		if(rs.hasErrors()) {
			model.addAttribute("listcat", catService.ListCat());
			return "add.land.admin";
		}
		fileName = FilenameUtils.getBaseName(fileName) + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
		land.setPicture(fileName);
		if(landService.addLand(land)>0) {
			String dirUpload = request.getServletContext().getRealPath("WEB-INF/resources/upload");
			File fileUpload = new File(dirUpload);
			if(!fileUpload.exists()) {
				fileUpload.mkdirs();
			}
			String filePath = dirUpload + File.separator + fileName;
			System.out.println(dirUpload);
			try {
				multipartfile.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			re.addFlashAttribute("msg", "Thêm tin thành công");
			return "redirect:/admin/land/index";
		}
		re.addFlashAttribute("msg", "Thêm tin thất bại");
		return "redirect:/admin/land/add";
	}
	
	@GetMapping("edit/{lid}")
	public String edit(HttpSession session, @PathVariable("lid") int lid, RedirectAttributes re, Model model) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		land land = new land();
		land.setLid(lid);
		if(landService.selectLandById(land) != null) {
			model.addAttribute("listcat", catService.ListCat());
			model.addAttribute("land", landService.selectLandById(land));
			return "edit.land.admin";
		}
		re.addFlashAttribute("msg", "ID không tồn tại");
		return "redirect:/admin/land/index";
	}
	
	@PostMapping("edit/{lid}")
	public String edit(@Valid @ModelAttribute("error") land land, BindingResult rs, Model model, RedirectAttributes re,
			           HttpServletRequest request, @RequestParam("hinhanh") MultipartFile multipartfile) {
		String fileName = multipartfile.getOriginalFilename();
		PictureValidator pictureValidator = new PictureValidator();
		pictureValidator.validate(fileName, rs);
		if(rs.hasErrors()) {
			model.addAttribute("listcat", catService.ListCat());
			model.addAttribute("land", landService.selectLandById(land));
			return "edit.land.admin";
		}
		fileName = FilenameUtils.getBaseName(fileName) + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
		land.setPicture(fileName);
		if(landService.editLand(land)>0) {
			String dirUpload = request.getServletContext().getRealPath("WEB-INF/resources/upload");
			File fileUpload = new File(dirUpload);
			if(!fileUpload.exists()) {
				fileUpload.mkdirs();
			}
			String filePath = dirUpload + File.separator + fileName;
			System.out.println(dirUpload);
			try {
				multipartfile.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			re.addFlashAttribute("msg", "Sửa thành công");
			return "redirect:/admin/land/index";
		}
		re.addFlashAttribute("msg", "Sửa thất bại");
		return "redirect:/admin/land/index";
	}
	
	@GetMapping("del/{lid}")
	public String del(@PathVariable("lid") int lid, HttpSession session, RedirectAttributes re) {
		if(session.getAttribute("session")==null) {
			return "redirect:/login";
		}
		land land = new land();
		land.setLid(lid);
		if(landService.selectLandById(land) == null) {
			re.addFlashAttribute("msg", "ID không tồn tại");
			return "redirect:/admin/land/index";
		}
		if(landService.delLand(land)>0) {
			re.addFlashAttribute("msg", "Xóa thành công");
			return "redirect:/admin/land/index";
		}
		re.addFlashAttribute("msg", "Xóa thất bại");
		return "redirect:/admin/land/index";
	}
	
}
