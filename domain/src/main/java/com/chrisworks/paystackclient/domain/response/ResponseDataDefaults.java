package com.chrisworks.paystackclient.domain.response;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public interface ResponseDataDefaults {

    BigInteger id();
    String domain();
    ZonedDateTime createdAt();
    ZonedDateTime updatedAt();
}
