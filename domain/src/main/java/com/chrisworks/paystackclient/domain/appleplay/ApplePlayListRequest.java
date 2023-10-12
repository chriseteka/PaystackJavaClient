package com.chrisworks.paystackclient.domain.appleplay;

import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedRequest;

public class ApplePlayListRequest extends PaystackListUnPagedRequest {

    private String next;
    private String previous;

    public ApplePlayListRequest(boolean useCursor) {
        super(useCursor);
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
