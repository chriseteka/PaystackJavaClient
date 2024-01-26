package io.github.chriseteka.paystackclient.domain.request;

import io.github.chriseteka.paystackclient.domain.PaystackException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;

import static io.github.chriseteka.paystackclient.domain.SerialisationUtil.objectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface RequestBody<T> {

    @SuppressWarnings("unchecked")
    private T raw() {
        return (T) this;
    }

    default String json() {
        try {
            return objectMapper.writeValueAsString(raw());
        } catch (JsonProcessingException e) {
            throw new PaystackException(e);
        }
    }
}
