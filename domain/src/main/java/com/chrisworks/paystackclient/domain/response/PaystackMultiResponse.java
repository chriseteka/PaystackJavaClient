package com.chrisworks.paystackclient.domain.response;

import java.math.BigInteger;
import java.util.List;

public interface PaystackMultiResponse<T extends ResponseDataDefaults> extends ResponseDefaults {

    List<T> data();
    PageMetaInfo meta();

    interface PageMetaInfo {

        BigInteger total();
        BigInteger skipped();
        BigInteger perPage();
        BigInteger page();
        BigInteger pageCount();

    }
}
