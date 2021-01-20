package org.coala.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProblemResult {
	@JsonProperty("SubNum")
	private int SubNum;
	@JsonProperty("Result")
	private int Result = 1;
	
}
