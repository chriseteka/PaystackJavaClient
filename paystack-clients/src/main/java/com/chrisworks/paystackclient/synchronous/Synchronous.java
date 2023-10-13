package com.chrisworks.paystackclient.synchronous;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.synchronous.definitions.ApplePayClient;
import com.chrisworks.paystackclient.synchronous.definitions.PlanClient;
import okhttp3.OkHttpClient;

public interface Synchronous {

    ApplePayClient applePlay();
    PlanClient plan();

    final class Impl extends WithConfiguredHttpClient implements Synchronous {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePayClient applePlay() {
            return new ApplePayClient.Impl(httpClient);
        }

        @Override
        public PlanClient plan() {
            return new PlanClient.Impl(httpClient);
        }
    }
}
