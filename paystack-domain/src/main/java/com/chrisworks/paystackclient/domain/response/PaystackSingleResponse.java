package com.chrisworks.paystackclient.domain.response;

public interface PaystackSingleResponse<T> extends ResponseDefaults {
    T data();
}
