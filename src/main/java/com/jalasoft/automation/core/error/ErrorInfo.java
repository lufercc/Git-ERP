package com.jalasoft.automation.core.error;


/**
 * Created by Mauricio Cadima on 6/22/2015.
 */
public class ErrorInfo {
    private ErrorType errorType;
    private String errorMessage;

    public ErrorInfo(ErrorType errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
