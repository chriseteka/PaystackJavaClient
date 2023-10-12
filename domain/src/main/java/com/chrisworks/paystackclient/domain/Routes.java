package com.chrisworks.paystackclient.domain;

public final class Routes {

    private Routes() {}

    private static final String BASE_URL = "https://api.paystack.co";

    public static final class ApplePlay {

        public static final String BASE_URL  = Routes.BASE_URL + "/apple-pay/domain";
    }

    public static final class Plan {
        public static final String BASE_URL = Routes.BASE_URL + "/plan";
    }
}
