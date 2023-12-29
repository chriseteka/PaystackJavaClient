package com.chrisworks.paystackclient.definitions.reactive;

import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;
import com.chrisworks.paystackclient.domain.response.EmptyDataResponse;
import com.chrisworks.paystackclient.definitions.Constants;
import com.maciejwalkowiak.spring.http.annotation.HttpClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpClient(Constants.APPLE_PAY_CLIENT)
public interface ApplePayClient {

    @PostExchange
    Mono<EmptyDataResponse> register(@RequestBody ApplePayRequest request);

    @DeleteExchange
    Mono<EmptyDataResponse> unregister(@RequestBody ApplePayRequest request);

    @GetExchange
    Mono<ApplePayResponse.Multiple> list(
            @RequestParam(name = QueryParamConstants.NEXT, required = false) String next,
            @RequestParam(name = QueryParamConstants.PREVIOUS, required = false) String previous,
            @RequestParam(name = QueryParamConstants.USE_CURSOR, required = false) Boolean useCursor
    );
}
