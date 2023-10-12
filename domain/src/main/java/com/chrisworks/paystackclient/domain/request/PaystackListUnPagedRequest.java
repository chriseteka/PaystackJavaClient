package com.chrisworks.paystackclient.domain.request;

public class PaystackListUnPagedRequest {

    protected final boolean use_cursor;

    public PaystackListUnPagedRequest(boolean useCursor) {
        use_cursor = useCursor;
    }
}
