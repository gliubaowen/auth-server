/**
 * 
 */
package com.lbw.auth.server.exception;

/**
 * common-server异常类
 * 
 * @author LiuBaoWen
 *
 */
public class AuthServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1782643205481474873L;

	/** 错误编码 */
	private String errorCode;

	/**
	 * @param message
	 */
	public AuthServerException(String message) {
		super(message);
	}

	/**
	 * @param errorCode
	 */
	public AuthServerException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 * @param message
	 * @param cause
	 */
	public AuthServerException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param cause
	 */
	public AuthServerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthServerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AuthServerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/** get 错误编码 */
	public String getErrorCode() {
		return errorCode;
	}

}
