package spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Student;
import spring.view.StudentExcelView;
import spring.view.StudentPDFView;

@Controller
//@RequestMapping("/")
public class GeneratorController {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView show ()
	{
		ModelAndView andView = new ModelAndView();
		andView.setViewName("studentReport");
		return andView;
	}
	
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public ModelAndView studentReport(HttpServletRequest request,HttpServletResponse response)
	{
		
		String typeReport = request.getParameter("type");
			
		List<Student> list = new ArrayList<Student>();
		for(int i=0;i<5;i++)
		{
			list.add(new Student(i, "user "+i, "city "+i, "10"+i));
		}
		if(typeReport != null &&typeReport.equals("xls"))
		{
			return new ModelAndView(new StudentExcelView(),"studentList",list);
		}
		else if(typeReport != null && typeReport.equals("pdf"))
		{
			return new ModelAndView(new StudentPDFView(),"studentList",list);
		}
		
		return new ModelAndView("studentReport","studentList",list);
	}
	
}
