package com.spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class resIsUnique {
	
	@RequestMapping(value="/spring/isunique", method = RequestMethod.POST)
	public JSONObject resIsUnique(@RequestBody String id){
		JSONObject obj = new JSONObject();
		
		obj.put("isUnique", "True");
		
		return obj;
	}

}
