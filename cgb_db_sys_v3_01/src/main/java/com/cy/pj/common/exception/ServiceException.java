package com.cy.pj.common.exception;

/**
 * 自定义非检查异常
 * 1）对业务中的信息进行更好的反馈和定位
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -5598865415547474216L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
