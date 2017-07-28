package com.sb.eatery.exception;


/***
 * 
 * Custom exception class
 * 
 * @author mguduru
 *
 */
public class InvalidInputSourceException extends BusinessException {
	private static final long serialVersionUID = 386353751289376875L;

	public InvalidInputSourceException(Throwable e) {
		super(e);
	}
}
