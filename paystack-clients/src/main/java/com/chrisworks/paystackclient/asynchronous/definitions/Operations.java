package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.domain.request.PaystackListPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.PaystackListUnPagedQueryParam;
import com.chrisworks.paystackclient.domain.request.RequestBody;
import com.chrisworks.paystackclient.domain.response.PaystackMultiResponse;
import com.chrisworks.paystackclient.domain.response.PaystackSingleResponse;
import com.chrisworks.paystackclient.domain.response.RichResponse;

import java.util.concurrent.CompletionStage;

final class Operations {

    private Operations() {}

    @FunctionalInterface
    interface Create<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {

        CompletionStage<RichResponse<Res>> create(Req body);
    }

    @FunctionalInterface
    interface FetchMultiple<Req extends PaystackListPagedQueryParam, Res extends PaystackMultiResponse<?>> {

        CompletionStage<RichResponse<Res>> fetchMultiple(Req queryParam);
    }

    @FunctionalInterface
    interface FetchMultipleUnPaged<Req extends PaystackListUnPagedQueryParam, Res extends PaystackSingleResponse<?>> {

        CompletionStage<RichResponse<Res>> fetchMultiple(Req queryParam);
    }

    @FunctionalInterface
    interface FetchByIdOrCode<Res extends PaystackSingleResponse<?>> {
        CompletionStage<RichResponse<Res>> fetchByIdOrCode(String idOrCode);
    }

    @FunctionalInterface
    interface UpdateByIdOrCode<Req extends RequestBody<?>, Res extends PaystackSingleResponse<?>> {
        CompletionStage<RichResponse<Res>> updateByIdOrCode(String idOrCode, Req body);
    }
}
