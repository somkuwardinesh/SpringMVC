package spring.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.ui.model.MyUser;
import spring.ui.service.MyUserService;

@Controller
public class AjaxController {

	@Autowired
	private MyUserService myUserService;

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView showPage() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("myUser", new MyUser());
		return modelAndView;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<MyUser> addUser(@RequestBody MyUser myUser) {
		if (myUser.getName().isEmpty() && myUser.getMobileNo() == 0
				&& myUser.getCity().isEmpty()) {
			return new ResponseEntity<MyUser>(HttpStatus.CONFLICT);
		} else {
			myUserService.saveMyUser(myUser);
			MyUser newUser = myUserService.findByName(myUser.getName());
			return new ResponseEntity<MyUser>(newUser, HttpStatus.CREATED);
		}

	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<MyUser>> deleteUser(@PathVariable("id") long id) {
		myUserService.deleteMyUserById(id);
		List<MyUser> list = myUserService.getMyUserList();
		if (list.isEmpty()) {
			return new ResponseEntity<List<MyUser>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<MyUser>>(list, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<List<MyUser>> updateUser(@RequestBody MyUser myUser) {
		if (myUser.getName().isEmpty() && myUser.getMobileNo() == 0
				&& myUser.getCity().isEmpty()) {
			return new ResponseEntity<List<MyUser>>(HttpStatus.CONFLICT);
		} else {
			myUserService.updateMyUser(myUser);
			List<MyUser> list = myUserService.getMyUserList();
			return new ResponseEntity<List<MyUser>>(list, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<MyUser> setUserUpadte(@PathVariable("id") long id) {
		MyUser newUser = myUserService.findByID(id);
		if (newUser == null) {
			return new ResponseEntity<MyUser>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<MyUser>(newUser, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<MyUser>> getAllUser() {
		List<MyUser> list = myUserService.getMyUserList();

		if (list.isEmpty()) {
			return new ResponseEntity<List<MyUser>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<MyUser>>(list, HttpStatus.OK);
		}

	}

}
