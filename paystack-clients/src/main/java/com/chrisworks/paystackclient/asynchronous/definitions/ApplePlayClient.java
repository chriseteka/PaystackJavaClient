package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.Create;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.FetchMultipleUnPaged;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import okhttp3.OkHttpClient;

import java.util.concurrent.CompletionStage;

public interface ApplePlayClient
        extends Create<ApplePayRequest, ApplePayResponse.Single>,
        FetchMultipleUnPaged<ApplePayListRequest, ApplePayResponse.Multiple> {

    CompletionStage<ApplePayResponse.Single> unregister(ApplePayRequest request);
    default CompletionStage<ApplePayResponse.Single> register(ApplePayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePlayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public CompletionStage<ApplePayResponse.Single> create(ApplePayRequest body) {
            return null;
        }

        @Override
        public ApplePayResponse.Multiple fetchMultiple(ApplePayListRequest body) {
            return null;
        }

        @Override
        public CompletionStage<ApplePayResponse.Single> unregister(ApplePayRequest request) {
            return null;
        }
    }
}
