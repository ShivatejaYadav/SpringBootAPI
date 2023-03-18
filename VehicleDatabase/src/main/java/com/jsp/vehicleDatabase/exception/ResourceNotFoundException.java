package com.jsp.vehicleDatabase.exception;

public class ResourceNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resource;
	private String fiesldname;
	private Object FieldValue;
	public ResourceNotFoundException(String resource, String fiesldname, Object fieldValue) {
		super();
		this.resource = resource;
		this.fiesldname = fiesldname;
		this.FieldValue = fieldValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getResource() {
		return resource;
	}
	public String getFiesldname() {
		return fiesldname;
	}
	public Object getFieldValue() {
		return FieldValue;
	}
	
	

}
