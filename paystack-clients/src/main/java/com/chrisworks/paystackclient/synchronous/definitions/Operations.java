package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.RequestBody;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.RichResponse;

final class Operations {

    private Operations() {}

    @FunctionalInterface
    interface Create<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {

        RichResponse<Res> create(Req body);
    }

    @FunctionalInterface
    interface FetchMultiple<Req extends PaystackListPagedQueryParam, Res extends PaystackMultiResponse<?>> {

        RichResponse<Res> fetchMultiple(Req queryParam);
    }

    @FunctionalInterface
    interface FetchMultipleUnPaged<Req extends PaystackListUnPagedQueryParam, Res extends PaystackSingleResponse<?>> {

        RichResponse<Res> fetchMultiple(Req queryParam);
    }

    @FunctionalInterface
    interface FetchByIdOrCode<Res extends PaystackSingleResponse<?>> {
        RichResponse<Res> fetchByIdOrCode(String idOrCode);
    }

    @FunctionalInterface
    interface UpdateByIdOrCode<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {
        RichResponse<Res> updateByIdOrCode(String idOrCode, Req body);
    }
}
