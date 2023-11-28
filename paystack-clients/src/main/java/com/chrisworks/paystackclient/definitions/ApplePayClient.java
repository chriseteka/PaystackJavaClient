package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListQueryParam;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.domain.response.EmptyDataResponse;
import okhttp3.*;

public interface ApplePayClient {

    ExecutionSpec<EmptyDataResponse> register(ApplePayRequest request);
    ExecutionSpec<EmptyDataResponse> unregister(ApplePayRequest request);
    ExecutionSpec<ApplePayResponse.Multiple> list(ApplePayListQueryParam queryParam);

    final class Impl extends WithConfiguredHttpClient implements ApplePayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<EmptyDataResponse> register(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, EmptyDataResponse.class);
        }

        @Override
        public ExecutionSpec<EmptyDataResponse> unregister(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .delete(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, EmptyDataResponse.class);
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
