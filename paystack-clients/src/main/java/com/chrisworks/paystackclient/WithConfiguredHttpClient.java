package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.domain.PaystackException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public abstract class WithConfiguredHttpClient {

    protected final ObjectMapper objectMapper = new ObjectMapper(); //Add maybe more config
    protected final MediaType applicationJson = MediaType.parse("application/json");
    protected final OkHttpClient httpClient;
    protected WithConfiguredHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    protected <T> T execute(Request request, Class<T> responseType) {
        try {
            final Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return objectMapper.readValue(response.body().string(), responseType);
            }
            throw new PaystackException(
                    objectMapper.readValue(response.body().string(), PaystackException.Model.class), response.code());
        } catch (IOException e) {
            throw new PaystackException(e);
        }
    }
}
