package spring.ui.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.ui.model.MyUser;
import spring.ui.service.MyUserService;
import spring.ui.validator.UserValidator;

@Controller
public class ValidationController {

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
	public String addUser( ModelMap modelMap,@ModelAttribute @Valid MyUser myUser,BindingResult result) {

		System.out.println("1");
			if(result.hasErrors())
			{
				System.out.println("2");
				return "register";
			}
			
		if (myUser.getId() == 0) {
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

	@InitBinder
	public void formInitBinder(WebDataBinder binderDataBinder)
	{
		final UserValidator userValidator = new UserValidator();
		binderDataBinder.setValidator(userValidator);
		
	}
}
