package com.mycom.myapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "1234/flask/")
public class ReqUserData {
	
	
	@RequestMapping(value = "userdata", method = RequestMethod.POST)
	public String reqUserData() {
		
		
		return "userdata";
	}
	
}
