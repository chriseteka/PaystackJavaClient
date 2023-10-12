package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedRequest;
import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedRequest;
import com.chrisworks.paystackclient.domain.request.RequestBody;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

final class Operations {

    private Operations() {}

    @FunctionalInterface
    interface Create<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {

        Res create(Req body);
    }

    @FunctionalInterface
    interface FetchMultiple<Req extends PaystackListPagedRequest, Res extends PaystackMultiResponse<?>> {

        Res fetchMultiple(Req body);
    }

    @FunctionalInterface
    interface FetchMultipleUnPaged<Req extends PaystackListUnPagedRequest, Res extends PaystackSingleResponse<?>> {

        Res fetchMultiple(Req body);
    }

    @FunctionalInterface
    interface FetchByIdOrCode<Res extends PaystackSingleResponse<?>> {
        Res fetchByIdOrCode(String idOrCode);
    }

    @FunctionalInterface
    interface UpdateByIdOrCode<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {
        Res updateByIdOrCode(String idOrCode, Req body);
    }
}
