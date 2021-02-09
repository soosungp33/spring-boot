package com.webb.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ProblemData {
	static final String furl = HomeController.furl;
	
	@RequestMapping(value = "/spring/probleminfo", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@CrossOrigin("*")
	public ResponseEntity<String> probinfo(@RequestBody String body) throws ParseException{
		// from React
		JSONParser jp = new JSONParser();
		JSONObject js = (JSONObject) jp.parse(body);
		JSONArray jsarr = new JSONArray();
		String Pnum = js.get("Pnum").toString();
		System.out.println(Pnum);
		
		// to Flask
		ResponseEntity<String> fresp = reqProbNum(Integer.parseInt(Pnum));
		
		// response to React
		JSONObject jsmain = new JSONObject();
		JSONObject js1 = (JSONObject) jp.parse(fresp.getBody().toString());
		jsarr.add(js1);
		jsmain.put("info", jsarr);
		System.out.println(jsmain.toJSONString());
		return ResponseEntity.ok(jsmain.toJSONString());
	}

	public ResponseEntity<String> reqProbNum(int pnum) {
		// make Body
		MultiValueMap<String, Integer> params = new LinkedMultiValueMap<>();
		params.add("Pnum", pnum);
		
		// make Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		// make Entity
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params, headers); 
		RestTemplate rt = new RestTemplate();
		String url = furl+"/flask_Problem_info";
		return rt.exchange(url, HttpMethod.POST, entity, String.class);
		
	}
}
