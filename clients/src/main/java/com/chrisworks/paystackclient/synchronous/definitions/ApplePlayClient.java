package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayListRequest;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayRequest;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayResponse;
import com.chrisworks.paystackclient.synchronous.definitions.Operations.*;
import okhttp3.*;


public interface ApplePlayClient
        extends Create<ApplePlayRequest, ApplePlayResponse.Single>,
        FetchMultipleUnPaged<ApplePlayListRequest, ApplePlayResponse.Multiple> {

    ApplePlayResponse.Single unregister(ApplePlayRequest request);
    default ApplePlayResponse.Single register(ApplePlayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePlayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePlayResponse.Single create(ApplePlayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePlay.BASE_URL)
                    .post(RequestBody.create(body.toJson(), applicationJson))
                    .build();

            return execute(request, ApplePlayResponse.Single.class);
        }

        @Override
        public ApplePlayResponse.Multiple fetchMultiple(ApplePlayListRequest body) {
            Request request = new Request.Builder()
                    .url(Routes.ApplePlay.BASE_URL)
                    .get()
                    .build();

            return execute(request, ApplePlayResponse.Multiple.class);
        }

        @Override
        public ApplePlayResponse.Single unregister(ApplePlayRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.ApplePlay.BASE_URL)
                    .delete(RequestBody.create(body.toJson(), applicationJson))
                    .build();

            return execute(request, ApplePlayResponse.Single.class);
        }
    }
}
