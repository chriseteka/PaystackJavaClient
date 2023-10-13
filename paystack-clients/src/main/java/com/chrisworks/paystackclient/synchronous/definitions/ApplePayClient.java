package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.applepay.ApplePayListQueryParam;
import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import com.chrisworks.paystackclient.synchronous.definitions.Operations.*;
import okhttp3.*;

public interface ApplePayClient
        extends Create<ApplePayRequest, ApplePayResponse.Single>,
        FetchMultipleUnPaged<ApplePayListQueryParam, ApplePayResponse.Multiple> {

    RichResponse<ApplePayResponse.Single> unregister(ApplePayRequest request);
    default RichResponse<ApplePayResponse.Single> register(ApplePayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public RichResponse<ApplePayResponse.Single> create(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execute(request, ApplePayResponse.Single.class);
        }

        @Override
        public RichResponse<ApplePayResponse.Multiple> fetchMultiple(ApplePayListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execute(request, ApplePayResponse.Multiple.class);
        }

        @Override
        public RichResponse<ApplePayResponse.Single> unregister(ApplePayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePay.BASE_URL)
                    .delete(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execute(request, ApplePayResponse.Single.class);
        }
    }
}
