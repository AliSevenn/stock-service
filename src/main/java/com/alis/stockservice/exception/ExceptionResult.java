package com.alis.stockservice.exception;

public class ExceptionResult {

	private final ExceptionType type;
	private final String message;
	private final String code;
	private final Object[] args;

	public ExceptionResult(ExceptionType type, String message, String code, Object[] args) {
		this.type = type;
		this.message = message;
		this.code = code;
		this.args = args;
	}

	public ExceptionType getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	public Object[] getArgs() {
		return args;
	}
}
