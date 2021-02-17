package org.coala.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import lombok.Data;

@Data
public class UserInfo extends Object{
	@JsonProperty("ID")
	private Object ID = "";
	@JsonProperty("Pwd")
	private Object Pwd = "";
	@JsonProperty("Name")
	private Object Name = "";
	@Override
	public String toString() {
		String json = new Gson().toJson(this);
		return json;
	}
	

}
