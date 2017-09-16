package com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;










import com.model.Accounts;
import com.read.xml.MyHandler;
import com.read.xml.ReadXML;

@RestController
public class XmlController {

	private final String location="J:\\requestFile\\";
	
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView show()
	{
		ModelAndView andView = new ModelAndView();
		andView.setViewName("show");
		return andView; 
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Accounts> addUser(@RequestParam("file") MultipartFile file)
	{
		Accounts a1=new Accounts("321", "A","876");
		try {
			//File f = new File(location+fileName);
			//file.transferTo(f);
			
			String fileName =file.getOriginalFilename();
			File file2 = new File("J:\\ResponseFile",fileName);
			if(file2.exists()) 
			{
				//when account no is exits
				ReadXML readXML = new ReadXML();
				a1 = readXML.readXml(fileName);			
				return new ResponseEntity<Accounts>(a1,HttpStatus.OK);
			}
			else
			{
				//when account not exist 
				return new ResponseEntity<Accounts>(a1,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Accounts>(a1,HttpStatus.BAD_REQUEST);
		}
		
	}
}

