package org.coalery.exception;

@SuppressWarnings("serial")
public class ValueNotFoundException extends Exception {
	
	private String content;
	
	public ValueNotFoundException(String content) { this.content = content; }
	
	@Override
	public String getMessage() {
		return "I can't find value by Content(" + content + ")";
	}
	
}
