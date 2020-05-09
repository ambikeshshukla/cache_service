package org.espressif.exception.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlRootElement;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "error")
public class ErrorResponse {

    private int errorCode = 500;

    private String errorDescr;

    private int reasonCode;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String errorDescr) {
        super();
        this.errorDescr = errorDescr;
    }

    public ErrorResponse(String errorDescr, int errorCode) {
        super();
        this.errorDescr = errorDescr;
        this.errorCode = errorCode;
    }


    public String getErrorDescr() {
        return errorDescr;
    }

    public void setErrorDescr(String errorDescr) {
        this.errorDescr = errorDescr;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }
}
