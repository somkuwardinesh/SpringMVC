package spring.inter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.inter.model.MyUser;

@Controller
public class InternationalController {


	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String showPage(ModelMap modelMap,
			@RequestParam(value = "message", required = false) String message,
			@RequestParam(value = "id", required = false) Long id) {
		MyUser myUser = new MyUser();
		/*if (id != null) {
			myUser = myUserService.findByID(id);
		}*/
		modelMap.addAttribute("myUser", myUser);
		modelMap.addAttribute("message", message);

		return "register";
	}
}
