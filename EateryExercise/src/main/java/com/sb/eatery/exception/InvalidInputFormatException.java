package com.sb.eatery.exception;


/**
 * Custom exception class
 * 
 * @author mguduru
 *
 */
public class InvalidInputFormatException extends BusinessException {
	private static final long serialVersionUID = 386353751289376875L;

	public InvalidInputFormatException(Throwable e) {
		super(e);
	}

	public InvalidInputFormatException() {
	}
}
