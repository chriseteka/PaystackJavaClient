package com.chrisworks.paystackclient.domain;

import java.util.function.UnaryOperator;

public final class Routes {

    private Routes() {}

    private static final String BASE_URL = "https://api.paystack.co";

    public static final class ApplePay {
        private ApplePay() {}
        public static final String BASE_URL  = Routes.BASE_URL + "/apple-pay/domain";
    }

    public static final class Customer {
        private Customer() {}
        public static final String BASE_URL  = Routes.BASE_URL + "/customer";
        public static final UnaryOperator<String> BY_CUSTOMER_CODE_OR_EMAIL = (BASE_URL + "/%s")::formatted;
        public static final UnaryOperator<String> VALIDATE_CUSTOMER_URL = (BASE_URL + "/%s/identification")::formatted;
        public static final String WHITE_OR_BLACK_LIST_URL  = BASE_URL + "/set_risk_action";
        public static final String DEACTIVATE_AUTHORIZATION_URL  = BASE_URL + "/deactivate_authorization";
    }

    public static final class Plan {
        private Plan() {}
        public static final String BASE_URL = Routes.BASE_URL + "/plan";
        public static final UnaryOperator<String> BY_ID_OR_CODE = (BASE_URL + "/%s")::formatted;
    }

    public static final class Transaction {
        private Transaction() {}

        public static final String BASE_URL = Routes.BASE_URL + "/transaction";
        public static final String INIT_TRANSACTION_URL = BASE_URL + "/initialize";
        public static final String TOTAL_TRANSACTION_URL = BASE_URL + "/totals";
        public static final String EXPORT_TRANSACTIONS_URL = BASE_URL + "/export";
        public static final String PARTIAL_DEBIT_URL = BASE_URL + "/partial_debit";
        public static final UnaryOperator<String> BY_ID = (BASE_URL + "/%s")::formatted;
        public static final String CHARGE_AUTHORIZATION_URL = BASE_URL + "/charge_authorization";
        public static final UnaryOperator<String> VIEW_TIMELINE_URL = (BASE_URL + "/timeline/%s")::formatted;
        public static final UnaryOperator<String> VERIFY_TRANSACTION_URL = (BASE_URL + "/verify/%s")::formatted;
    }

    public static final class Product {
        private Product(){}
        public static final String BASE_URL = Routes.BASE_URL + "/product";
        public static final UnaryOperator<String> BY_ID = (BASE_URL + "/%s")::formatted;
    }
}
