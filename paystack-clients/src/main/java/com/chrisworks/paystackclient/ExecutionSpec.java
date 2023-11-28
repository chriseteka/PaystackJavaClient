package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.domain.PaystackException;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.chrisworks.paystackclient.domain.SerialisationUtil.objectMapper;

public final class ExecutionSpec<T> {

    private final Request req;
    private final Class<T> retType;
    private final OkHttpClient httpClient;

    ExecutionSpec(Request req, Class<T> retType, OkHttpClient httpClient) {
        this.req = req;
        this.retType = retType;
        this.httpClient = httpClient;
    }

    public RichResponse<T> execute() {
        try(final Response response = httpClient.newCall(req).execute()) {
            final String responseBody = response.body().string();
            if (response.isSuccessful()) {
                return new RichResponse.RichResponseImpl<>(objectMapper.readValue(responseBody, retType), responseBody);
            }
            throw new PaystackException(
                    objectMapper.readValue(responseBody, PaystackException.Model.class), response.code());
        } catch (IOException e) {
            throw new PaystackException(e);
        }
    }

    //TODO: waits a really long time before releasing thread
    public CompletableFuture<RichResponse<T>> executeAsync() {
        final CompletableFuture<RichResponse<T>> future = new CompletableFuture<>();
        httpClient.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseBody = response.body().string();
                if (response.isSuccessful()) {
                    future.complete(new RichResponse.RichResponseImpl<>(objectMapper.readValue(responseBody, retType), responseBody));
                }
                else {
                    future.completeExceptionally(new PaystackException(
                            objectMapper.readValue(responseBody, PaystackException.Model.class), response.code()));
                }
                response.close();
            }
        });

        return future;
    }
}
