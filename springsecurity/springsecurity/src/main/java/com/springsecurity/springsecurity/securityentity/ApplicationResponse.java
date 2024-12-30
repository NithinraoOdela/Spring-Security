package com.springsecurity.springsecurity.securityentity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationResponse {

	private String username;
	private String message;
}
