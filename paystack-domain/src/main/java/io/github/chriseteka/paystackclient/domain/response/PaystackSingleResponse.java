package io.github.chriseteka.paystackclient.domain.response;

public interface PaystackSingleResponse<T> extends ResponseDefaults {
    T data();
}
