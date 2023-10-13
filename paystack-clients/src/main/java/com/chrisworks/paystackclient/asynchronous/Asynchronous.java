package com.chrisworks.paystackclient.asynchronous;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.asynchronous.definitions.ApplePlayClient;
import com.chrisworks.paystackclient.asynchronous.definitions.PlanClient;
import okhttp3.OkHttpClient;

public interface Asynchronous {

    ApplePlayClient applePlay();
    PlanClient plan();

    final class Impl extends WithConfiguredHttpClient implements Asynchronous {
        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePlayClient applePlay() {
            return new ApplePlayClient.Impl(httpClient);
        }

        @Override
        public PlanClient plan() {
            return new PlanClient.Impl(httpClient);
        }
    }
}
