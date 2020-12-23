package com.alis.stockservice.exception;

public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String code;
    private final ExceptionType type;
    private final Object[] args;

    BaseException(ExceptionType type, String code, Object... args) {
        this.type = type;
        this.code = code;
        this.args = args;
    }

	public String getCode() {
		return code;
	}

	public ExceptionType getType() {
		return type;
	}

	public Object[] getArgs() {
		return args;
	}

}

