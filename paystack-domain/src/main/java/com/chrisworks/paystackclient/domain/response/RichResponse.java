package com.chrisworks.paystackclient.domain.response;

import com.chrisworks.paystackclient.domain.PaystackException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static com.chrisworks.paystackclient.domain.SerialisationUtil.objectMapper;

public interface RichResponse<T> {

    T result();
    String raw();
    @SuppressWarnings("unchecked")
    default Map<String, Object> rawJsonAsMap() {
        try {
            return objectMapper.readValue(raw(), Map.class);
        } catch (JsonProcessingException e) {
            throw new PaystackException(e); //TODO: Throw something else
        }
    }

    record Impl<T>(T result, String raw) implements RichResponse<T> { }
}
