package com.cy.pj.sys.common.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -6143071993418352986L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException() {
    }
}
