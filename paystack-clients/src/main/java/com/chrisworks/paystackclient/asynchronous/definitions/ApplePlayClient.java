package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.Create;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.FetchMultipleUnPaged;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListQueryParam;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.OkHttpClient;

import java.util.concurrent.CompletionStage;

public interface ApplePlayClient
        extends Create<ApplePayRequest, ApplePayResponse.Single>,
        FetchMultipleUnPaged<ApplePayListQueryParam, ApplePayResponse.Multiple> {

    CompletionStage<RichResponse<ApplePayResponse.Single>> unregister(ApplePayRequest request);
    default CompletionStage<RichResponse<ApplePayResponse.Single>> register(ApplePayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePlayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public CompletionStage<RichResponse<ApplePayResponse.Single>> create(ApplePayRequest body) {
            return null;
        }

        @Override
        public CompletionStage<RichResponse<ApplePayResponse.Multiple>> fetchMultiple(ApplePayListQueryParam queryParam) {
            return null;
        }

        @Override
        public CompletionStage<RichResponse<ApplePayResponse.Single>> unregister(ApplePayRequest request) {
            return null;
        }
    }
}
