package com.spring.controller;

import com.spring.domain.SubmitData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReqSubmitData {

	@RequestMapping(value = "/flask/getproblem", method = RequestMethod.POST)
	public SubmitData ReqSubmitData() {
		SubmitData RSubmitData = new SubmitData();
		RSubmitData.setSubNum(5555);
		RSubmitData.setPnum(555);
		RSubmitData.setUserId("haha");
		return RSubmitData;
	}
	
}