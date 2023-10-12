package com.chrisworks.paystackclient.domain.response;

public interface PaystackSingleResponse<T extends ResponseDataDefaults> extends ResponseDefaults {
    T data();
}
