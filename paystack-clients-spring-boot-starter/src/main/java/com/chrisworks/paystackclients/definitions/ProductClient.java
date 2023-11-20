package com.chrisworks.paystackclients.definitions;

import com.chrisworks.paystackclient.domain.product.CreateProductRequest;
import com.chrisworks.paystackclient.domain.product.ProductResponse;
import com.chrisworks.paystackclient.domain.request.QueryParamConstants;
import com.maciejwalkowiak.spring.http.annotation.HttpClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@HttpClient(Constants.PRODUCT_CLIENT)
public interface ProductClient {

    @PostExchange
    ProductResponse.Single createProduct(@RequestBody CreateProductRequest body);

    @GetExchange
    ProductResponse.Multiple listProducts(
            @RequestParam(name = QueryParamConstants.PAGE) @NonNull BigInteger page,
            @RequestParam(name = QueryParamConstants.PER_PAGE) @NonNull BigInteger perPage,
            @RequestParam(name = QueryParamConstants.FROM, required = false)ZonedDateTime from,
            @RequestParam(name = QueryParamConstants.TO, required = false)ZonedDateTime to
            );

    @GetExchange("/{id}")
    ProductResponse.Single fetchProduct(@PathVariable String id);

    @PutExchange("/{id}")
    ProductResponse.Multiple updateProduct(@PathVariable String id);
}
