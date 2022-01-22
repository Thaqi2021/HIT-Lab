package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resoureName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resoureName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s:'%s'",resoureName,fieldName,fieldValue));
		this.resoureName = resoureName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResoureName() {
		return resoureName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}

}
