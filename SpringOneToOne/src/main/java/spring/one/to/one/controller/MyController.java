package spring.one.to.one.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.one.to.one.model.Course;
import spring.one.to.one.model.Student;
import spring.one.to.one.service.StudentService;

@Controller
public class MyController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showPage(ModelMap modelMap,
			@RequestParam(value = "message", required = false) String message) {
		Student student = new Student();
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("message", message);
		return "register";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(ModelMap modelMap, @ModelAttribute Student student) {
		long id = studentService.saveStudent(student);

		if (id > 0) {
			modelMap.addAttribute("message", "student added successfully");
			return "redirect:index";
		} else {
			modelMap.addAttribute("message", "student is not added ");
			return "redirect:index";
		}

	}

	@ModelAttribute("cmap")
	public Map<Long, String> getAllCource() {
		return studentService.getAllCources();
	}

}
