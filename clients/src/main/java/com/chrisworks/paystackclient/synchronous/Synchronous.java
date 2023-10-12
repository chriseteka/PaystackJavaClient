package com.chrisworks.paystackclient.synchronous;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.synchronous.definitions.ApplePlayClient;
import com.chrisworks.paystackclient.synchronous.definitions.PlanClient;
import okhttp3.OkHttpClient;

public interface Synchronous {

    ApplePlayClient applePlayClient();
    PlanClient planClient();

    final class Impl extends WithConfiguredHttpClient implements Synchronous {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePlayClient applePlayClient() {
            return new ApplePlayClient.Impl(httpClient);
        }

        @Override
        public PlanClient planClient() {
            return new PlanClient.Impl(httpClient);
        }
    }
}
