package com.chrisworks.paystackclient.domain.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface RequestBody<T> {

    ObjectMapper o = new ObjectMapper();
    default String toJson() {
        try {
            return o.writeValueAsString(((T) this)); //Gson serializing stuff
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
