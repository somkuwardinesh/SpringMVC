package spring.inter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.inter.model.MyUser;

@Controller
public class IntercepterController {


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showPage(ModelMap modelMap) {
		MyUser myUser = new MyUser();
		modelMap.addAttribute("myUser", myUser);
		return "register";
	}
	
	@RequestMapping(value = "/sunday", method = RequestMethod.GET)
	public String sundayPage() {
		return "sunday";
	}
}
