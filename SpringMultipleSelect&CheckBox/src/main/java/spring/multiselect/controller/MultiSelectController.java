package spring.multiselect.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.multiselect.model.Student;


@Controller
public class MultiSelectController {

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String showPage(ModelMap modelMap,
			@RequestParam(value = "message", required = false) String message) {
		Student student = new Student();
		modelMap.addAttribute("student", student);
		modelMap.addAttribute("message", message);
		return "register";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(ModelMap modelMap, @ModelAttribute Student student) {
		
		System.out.println("name :"+student.getName());
		System.out.println("age :"+student.getAge());
		System.out.println("city :"+student.getCity());

		System.out.print("Course ID ");
		for (Long i : student.getCourse()) {
			System.out.print(" : "+i);
		}
		System.out.println();
		System.out.print("Movies ID ");
		for (Long i : student.getMovies()) {
			System.out.print(" : "+i);
		}
		return "register";
	}

	@ModelAttribute("cmap")
	public Map<Long, String> getAllCource() {
		Map<Long, String> map = new HashMap<Long, String>();
				map.put(1L, "Java");
				map.put(2L, "C pro");
				map.put(3L, "C++");
				map.put(4L, "PHP");
				map.put(5L, ".net");
				map.put(6L, "ruby");
		return map;
	}
	
	@ModelAttribute("mmap")
	public Map<Long, String> getAllMovie() {
		Map<Long, String> map = new HashMap<Long, String>();
				map.put(1L, "Kick");
				map.put(2L, "Wanted");
				map.put(3L, "Tubelight");
				map.put(4L, "Gabbar");
				map.put(5L, "Judawa");
				map.put(6L, "Force");
		return map;
	}
}
