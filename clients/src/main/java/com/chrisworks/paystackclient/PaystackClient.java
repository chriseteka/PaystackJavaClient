package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.asynchronous.Asynchronous;
import com.chrisworks.paystackclient.synchronous.Synchronous;
import okhttp3.OkHttpClient;

public interface PaystackClient {

    Synchronous synchronous();
    Asynchronous asynchronous();

    final class Impl extends WithConfiguredHttpClient implements PaystackClient {
        Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public Synchronous synchronous() {
            return new Synchronous.Impl(httpClient);
        }

        @Override
        public Asynchronous asynchronous() {
            return new Asynchronous.Impl(httpClient);
        }
    }
}
