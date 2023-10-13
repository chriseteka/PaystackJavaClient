package com.chrisworks.paystackclient.domain;

public enum Interval {
    DAILY,
    WEEKLY,
    MONTHLY,
    QUARTERLY,
    BIANNUALLY,
    ANNUALLY;

    public static Interval valueOfIgnoreCase(String str) {
        return valueOf(str.toUpperCase());
    }
}
