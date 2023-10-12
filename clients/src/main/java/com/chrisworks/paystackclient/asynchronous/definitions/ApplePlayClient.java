package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.Create;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.FetchMultipleUnPaged;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayListRequest;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayRequest;
import com.chrisworks.paystackclient.domain.appleplay.ApplePlayResponse;
import okhttp3.OkHttpClient;

import java.util.concurrent.CompletionStage;

public interface ApplePlayClient
        extends Create<ApplePlayRequest, ApplePlayResponse.Single>,
        FetchMultipleUnPaged<ApplePlayListRequest, ApplePlayResponse.Multiple> {

    CompletionStage<ApplePlayResponse.Single> unregister(ApplePlayRequest request);
    default CompletionStage<ApplePlayResponse.Single> register(ApplePlayRequest request) {
        return create(request);
    }

    final class Impl extends WithConfiguredHttpClient implements ApplePlayClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public CompletionStage<ApplePlayResponse.Single> create(ApplePlayRequest body) {
            return null;
        }

        @Override
        public ApplePlayResponse.Multiple fetchMultiple(ApplePlayListRequest body) {
            return null;
        }

        @Override
        public CompletionStage<ApplePlayResponse.Single> unregister(ApplePlayRequest request) {
            return null;
        }
    }
}
