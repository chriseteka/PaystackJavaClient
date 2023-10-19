package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.domain.request.QueryParamBuilder;
import okhttp3.*;

import java.util.Optional;

public abstract class WithConfiguredHttpClient {

    protected final MediaType applicationJson = MediaType.parse("application/json");
    protected final OkHttpClient httpClient;
    protected WithConfiguredHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    protected <T extends QueryParamBuilder> String safeExtractQueryParams(T queryParamBuilder) {
        return Optional.ofNullable(queryParamBuilder)
                .map(QueryParamBuilder::buildParams)
                .orElse("");
    }

    protected <T> ExecutionSpec<T> execSpec(Request request, Class<T> returnType) {
        return new ExecutionSpec<>(request, returnType, httpClient);
    }
}
