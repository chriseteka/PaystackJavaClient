package io.github.chriseteka.paystackclient.domain.response;

import io.github.chriseteka.paystackclient.domain.PaystackException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static io.github.chriseteka.paystackclient.domain.SerialisationUtil.objectMapper;

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

    record RichResponseImpl<T>(T result, String raw) implements RichResponse<T> { }
}
