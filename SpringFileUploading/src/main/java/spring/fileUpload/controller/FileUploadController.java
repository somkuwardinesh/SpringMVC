package spring.fileUpload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.fileUpload.model.MyUser;

@Controller
public class FileUploadController {

	// this is for saving images in other folder
	// private static final String UPLOAD_DIRECTORY = "E://Dineshimage//";

	// this is for saving images in Project
	private static final String UPLOAD_DIRECTORY = "E://Dinesh//Practics Project//GIT_Project//Spring_MVC//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//SpringFileUploading//WEB-INF//images//";

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String showPage(ModelMap modelMap) {
		MyUser myUser = new MyUser();
		modelMap.addAttribute("myUser", myUser);
		return "register";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(ModelMap modelMap, @ModelAttribute MyUser myUser) throws IOException {
		
		System.out.println("Name :"+myUser.getName());
		System.out.println("City :"+myUser.getCity());
		System.out.println("Mobile No :"+myUser.getMobileNo());
		System.out.println("Images :");
		
		CommonsMultipartFile[] file = myUser.getFleUpload();
		for (CommonsMultipartFile commonsMultipartFile : file) {	
			byte[] bytes = commonsMultipartFile.getBytes();
			Path path1 = Paths.get(UPLOAD_DIRECTORY
					+ commonsMultipartFile.getOriginalFilename());
			Files.write(path1, bytes);
			System.out.println(path1);
		}
		return "redirect:/index";
	}
}

