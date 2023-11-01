package com.chrisworks.paystackclients.definitions;

import com.chrisworks.paystackclient.domain.applepay.ApplePayRequest;
import com.chrisworks.paystackclient.domain.applepay.ApplePayResponse;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;
import com.maciejwalkowiak.spring.http.annotation.HttpClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpClient(Constants.APPLE_PAY_CLIENT)
public interface ApplePayClient {

    @PostExchange
    ApplePayResponse.Single register(@RequestBody ApplePayRequest request);

    @DeleteExchange
    ApplePayResponse.Single unregister(@RequestBody ApplePayRequest request);

    @GetExchange
    ApplePayResponse.Multiple list(
            @RequestParam(name = QueryParamConstants.NEXT, required = false) String next,
            @RequestParam(name = QueryParamConstants.PREVIOUS, required = false) String previous,
            @RequestParam(name = QueryParamConstants.USE_CURSOR, required = false) Boolean useCursor
    );
}
