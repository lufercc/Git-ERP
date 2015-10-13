package com.jalasoft.automation.core.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauricio Cadima on 6/22/2015.
 */
public class ErrorInfoCollection {
    private List<ErrorInfo> errorInfoList;

    public ErrorInfoCollection() {
        this.errorInfoList = new ArrayList<>();
    }

    public void addError(ErrorType errorType, String errorMessage) {
        this.errorInfoList.add(new ErrorInfo(errorType, errorMessage));
    }

    public void addAllErrors(List<ErrorInfo> errors) {
        for (ErrorInfo error : errors) {
            this.errorInfoList.add(new ErrorInfo(error.getErrorType(), error.getErrorMessage()));
        }
    }

    public int getErrorCount() {
        return this.errorInfoList.size();
    }

    public boolean hasErrors() {
        return this.errorInfoList.size() > 0;
    }

    public List<ErrorInfo> getErrorInfoList() {
        return this.errorInfoList;
    }

    public String getConsolidatedMessage() {
        StringBuilder sb = new StringBuilder();
        for (ErrorInfo errorInfo : this.errorInfoList) {
            sb.append(errorInfo.getErrorMessage());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
