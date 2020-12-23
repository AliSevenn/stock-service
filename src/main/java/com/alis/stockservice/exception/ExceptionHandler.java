package com.alis.stockservice.exception;

public interface ExceptionHandler {
	public ExceptionResult handle(Throwable exception);
}