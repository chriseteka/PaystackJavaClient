package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedRequest;
import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedRequest;
import com.chrisworks.paystackclient.domain.request.RequestBody;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;

import java.util.concurrent.CompletionStage;

final class Operations {

    private Operations() {}

    @FunctionalInterface
    interface Create<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {

        CompletionStage<Res> create(Req body);
    }

    @FunctionalInterface
    interface FetchMultiple<Req extends PaystackListPagedRequest, Res extends PaystackMultiResponse<?>> {

        CompletionStage<Res> fetchMultiple(Req body);
    }

    @FunctionalInterface
    interface FetchMultipleUnPaged<Req extends PaystackListUnPagedRequest, Res extends PaystackSingleResponse<?>> {

        Res fetchMultiple(Req body);
    }

    @FunctionalInterface
    interface FetchByIdOrCode<Res extends PaystackSingleResponse<?>> {
        CompletionStage<Res> fetchByIdOrCode(String idOrCode);
    }

    @FunctionalInterface
    interface UpdateByIdOrCode<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {
        CompletionStage<Res> updateByIdOrCode(String idOrCode, Req body);
    }
}
