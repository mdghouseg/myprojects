package com.sb.eatery.exception;


/***
 * 
 * CustomException class
 * 
 * @author mguduru
 *
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -1626501420467939474L;

	public BusinessException() {
	}

	public BusinessException(String str) {
		super(str);
	}

	public BusinessException(Throwable e) {
		super(e);
	}
}
