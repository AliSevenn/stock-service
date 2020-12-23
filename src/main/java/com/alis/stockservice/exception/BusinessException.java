package com.alis.stockservice.exception;

public class BusinessException extends BaseException {
    private static final long serialVersionUID = 12313321L;

    public BusinessException(String code) {
        super(ExceptionType.BUSINESS, code);
    }

    public BusinessException(String code, Object... args) {
        super(ExceptionType.BUSINESS, code, args);
    }
}