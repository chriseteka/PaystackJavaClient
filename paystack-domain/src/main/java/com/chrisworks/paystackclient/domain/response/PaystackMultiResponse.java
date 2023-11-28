package com.chrisworks.paystackclient.domain.response;

import java.math.BigInteger;
import java.util.List;

public interface PaystackMultiResponse<T> extends ResponseDefaults {

    List<T> data();
    PageInfo meta();

    interface PageInfo {

        BigInteger total();
        BigInteger skipped();
        BigInteger perPage();
        BigInteger page();
        BigInteger pageCount();

        record PageMetaInfo(BigInteger total, BigInteger skipped, BigInteger perPage, BigInteger page, BigInteger pageCount) implements PageInfo {}

    }
}
