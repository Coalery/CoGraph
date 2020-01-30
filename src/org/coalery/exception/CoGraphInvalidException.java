package org.coalery.exception;

@SuppressWarnings("serial")
public class CoGraphInvalidException extends Exception {
	
	private String msg;
	
	public CoGraphInvalidException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Graph! : " + msg;
	}

}