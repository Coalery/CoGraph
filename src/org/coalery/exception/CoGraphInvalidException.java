package org.coalery.exception;

@SuppressWarnings("serial")
public class CoGraphInvalidException extends Exception {

	@Override
	public String getMessage() {
		return "Invalid Graph!";
	}

}