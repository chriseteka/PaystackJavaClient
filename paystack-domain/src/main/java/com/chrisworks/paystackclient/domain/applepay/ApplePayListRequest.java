package com.chrisworks.paystackclient.domain.applepay;

import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedRequest;

//FIXME: This is wrong, ought to be request params, I defined it as body :alien:
public class ApplePayListRequest extends PaystackListUnPagedRequest {

    private String next;
    private String previous;

    public ApplePayListRequest(boolean useCursor) {
        super(useCursor);
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
