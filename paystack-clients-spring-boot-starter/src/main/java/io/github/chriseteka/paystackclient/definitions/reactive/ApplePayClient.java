package io.github.chriseteka.paystackclient.definitions.reactive;

import io.github.chriseteka.paystackclient.domain.applepay.ApplePayRequest;
import io.github.chriseteka.paystackclient.domain.applepay.ApplePayResponse;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;
import io.github.chriseteka.paystackclient.domain.response.EmptyDataResponse;
import io.github.chriseteka.paystackclient.definitions.Constants;
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
