package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.synchronous.definitions.Operations.*;
import okhttp3.*;

//TODO: What if we use the right term as see in their Doc, instead of our custom?
public interface ApplePayClient
        extends Create<ApplePayRequest, ApplePayResponse.Single>,
        FetchMultipleUnPaged<ApplePayListRequest, ApplePayResponse.Multiple> {

    ApplePayResponse.Single unregister(ApplePayRequest request);
    default ApplePayResponse.Single register(ApplePayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePayResponse.Single create(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .post(RequestBody.create(body.toJson(), applicationJson))
                    .build();

            return execute(request, ApplePayResponse.Single.class);
        }

        @Override
        public ApplePayResponse.Multiple fetchMultiple(ApplePayListRequest body) {
            Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .get()
                    .build();

            return execute(request, ApplePayResponse.Multiple.class);
        }

        @Override
        public ApplePayResponse.Single unregister(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .delete(RequestBody.create(body.toJson(), applicationJson))
                    .build();

            return execute(request, ApplePayResponse.Single.class);
        }
    }
}
