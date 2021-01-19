package org.coala.controller;

import org.coala.domain.ProblemResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class SendProbRes {
	
	@PostMapping(value="/spring/getproblemresult", produces="application/json;charset=UTF-8")
	public ProblemResult sendProbRes(@RequestBody ProblemResult probRes) {
		probRes.setSubNum(probRes.getSubNum()+1);
		log.info("sendProbRes....." + probRes);
		return probRes;
	}

}
