package spring.oneTomany.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import spring.oneTomany.model.Images;
import spring.oneTomany.model.MyUser;
import spring.oneTomany.service.MyUserService;



@Controller
public class MyController {

	private static final String UPLOAD_DIRECTORY="E://Dineshimage//";
	
	@Autowired
	private MyUserService myUserService;

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String showPage(ModelMap modelMap,
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "id", required = false) Long id) {
		MyUser myUser = new MyUser();
		if (id != null) {
			myUser = myUserService.findByID(id);
		}
		modelMap.addAttribute("myUser", myUser);
		modelMap.addAttribute("message", message);

		return "register";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute MyUser myUser, ModelMap modelMap) throws Exception{
		List<Images> imageList = new ArrayList<>();

		System.out.println("1");
		if (myUser.getId() == 0) {
			CommonsMultipartFile[] file = myUser.getFleUpload();
			for (CommonsMultipartFile commonsMultipartFile : file) {
				Images img = new Images();
				byte[] bytes = commonsMultipartFile.getBytes();
				Path path1 = Paths.get(UPLOAD_DIRECTORY
						+ commonsMultipartFile.getOriginalFilename());
				Files.write(path1, bytes);
				
				img.setImageName(commonsMultipartFile.getOriginalFilename());
				imageList.add(img);
			}
			myUser.setImageList(imageList);
			myUserService.saveMyUser(myUser);
			modelMap.addAttribute("message", "user added Successfully");
			return "redirect:/index";
		} else {
			myUserService.updateMyUser(myUser);
			modelMap.addAttribute("message", "user Updated Successfully");
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(ModelMap modelMap,
			@RequestParam(value = "id", required = false) Long id) {
		myUserService.deleteMyUserById(id);
		modelMap.addAttribute("message", "user Deleted Successfully");
		return "redirect:/index";
	}

	@ModelAttribute("myUserList")
	public List<MyUser> getAllUser() {
		return myUserService.getMyUserList();
	}

}
