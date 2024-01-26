package io.github.chriseteka.paystackclient.domain;


public record Authorization(String authorization_code, String bin, String last4, String exp_month, String exp_year,
                            String channel, String card_type, String bank, String country_code, String brand,
                            boolean reusable, String signature, String account_name) {
}
