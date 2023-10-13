package com.chrisworks.paystackclient.domain.request;

import java.util.Map;
import java.util.stream.Collectors;

public interface QueryParamBuilder {

    Map<String, String> params();
    default String buildParams() {
        final String params = params()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        return (params.isBlank() || params.isEmpty()) ? params : "?" + params;
    }
}
