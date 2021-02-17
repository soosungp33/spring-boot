package org.coala.controller;

import org.coala.domain.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class ReqSignUp {

	@PostMapping(value="/spring/reqSignUP", produces="application/json;charset=UTF-8")
	public HttpEntity<String> reqSignUp(Object ID,Object Pwd, Object Name) {
		ID = String.valueOf(ID);
		Pwd = String.valueOf(Pwd);
		Name = String.valueOf(Name);
		UserInfo user = new UserInfo();
		user.setID(ID);
		user.setPwd(Pwd);
		user.setName(Name);
		log.info("user : " + user.toString());
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		HttpEntity<String> request;
		request = new HttpEntity<>(user.toString(),header);
		log.info("HttpEntity : " + request);
		return request;
	}
}


