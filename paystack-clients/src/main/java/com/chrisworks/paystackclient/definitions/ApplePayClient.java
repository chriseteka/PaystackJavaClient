package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListQueryParam;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import okhttp3.*;

public interface ApplePayClient {

    ExecutionSpec<ApplePayResponse.Single> register(ApplePayRequest request);
    ExecutionSpec<ApplePayResponse.Single> unregister(ApplePayRequest request);
    ExecutionSpec<ApplePayResponse.Multiple> list(ApplePayListQueryParam queryParam);

    final class Impl extends WithConfiguredHttpClient implements ApplePayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<ApplePayResponse.Single> register(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, ApplePayResponse.Single.class);
        }

        @Override
        public ExecutionSpec<ApplePayResponse.Single> unregister(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .delete(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, ApplePayResponse.Single.class);
        }

        @Override
        public ExecutionSpec<ApplePayResponse.Multiple> list(ApplePayListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, ApplePayResponse.Multiple.class);
        }
    }
}
