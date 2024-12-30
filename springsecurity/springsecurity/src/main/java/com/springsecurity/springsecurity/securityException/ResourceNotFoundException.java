package com.springsecurity.springsecurity.securityException;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

	private String userName;
	private String fieldName;
	private String fieldvalue;
}
