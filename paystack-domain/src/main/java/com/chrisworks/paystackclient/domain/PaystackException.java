package com.chrisworks.paystackclient.domain;

public class PaystackException extends RuntimeException {

    private final boolean status;
    private final String message;
    private final int httpStatusCode;

    public PaystackException(String message, boolean status, int httpStatusCode) {
        super(message);
        this.status = status;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public PaystackException(Exception e) {
        super(e);
        this.status = false;
        this.httpStatusCode = 500;
        this.message = e.getMessage();
    }

    public PaystackException(Model model, int httpStatusCode) {
        this.status = model.status;
        this.message = model.message;
        this.httpStatusCode = httpStatusCode;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public record Model(boolean status, String message) {}
}
