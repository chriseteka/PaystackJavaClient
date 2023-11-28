package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.definitions.ApplePayClient;
import com.chrisworks.paystackclient.definitions.CustomerClient;
import com.chrisworks.paystackclient.definitions.PlanClient;
import com.chrisworks.paystackclient.definitions.ProductClient;
import com.chrisworks.paystackclient.definitions.TransactionClient;
import okhttp3.OkHttpClient;

public interface PaystackClient {

    ApplePayClient applePay();
    CustomerClient customer();
    PlanClient plan();
    TransactionClient transaction();
    ProductClient product();

    final class Impl extends WithConfiguredHttpClient implements PaystackClient {
        Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ApplePayClient applePay() {
            return new ApplePayClient.Impl(httpClient);
        }

        @Override
        public CustomerClient customer() {
            return new CustomerClient.Impl(httpClient);
        }

        @Override
        public PlanClient plan() {
            return new PlanClient.Impl(httpClient);
        }

        @Override
        public TransactionClient transaction() {
            return new TransactionClient.Impl(httpClient);
        }

        @Override
        public ProductClient product() {
            return new ProductClient.Impl(httpClient);
        }
    }
}
