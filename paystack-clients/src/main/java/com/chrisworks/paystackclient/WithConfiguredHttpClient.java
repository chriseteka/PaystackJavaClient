package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.domain.PaystackException;
import com.chrisworks.paystackclient.domain.request.QueryParamBuilder;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

import static com.chrisworks.paystackclient.domain.SerialisationUtil.objectMapper;

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

    protected <T> RichResponse<T> execute(Request request, Class<T> responseType) {
        try(final Response response = httpClient.newCall(request).execute()) {
            final String responseBody = response.body().string();
            if (response.isSuccessful()) {
                return new RichResponse.Impl<>(objectMapper.readValue(responseBody, responseType), responseBody);
            }
            throw new PaystackException(
                    objectMapper.readValue(responseBody, PaystackException.Model.class), response.code());
        } catch (IOException e) {
            throw new PaystackException(e);
        }
    }
}
