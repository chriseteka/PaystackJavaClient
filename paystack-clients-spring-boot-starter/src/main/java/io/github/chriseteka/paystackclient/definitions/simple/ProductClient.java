package io.github.chriseteka.paystackclient.definitions.simple;

import io.github.chriseteka.paystackclient.domain.product.CreateOrUpdateProductRequest;
import io.github.chriseteka.paystackclient.domain.product.ProductResponse;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;
import io.github.chriseteka.paystackclient.definitions.Constants;
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
    ProductResponse.Single createProduct(@RequestBody CreateOrUpdateProductRequest body);

    @GetExchange
    ProductResponse.Multiple listProducts(
            @RequestParam(name = QueryParamConstants.PAGE, required = false, defaultValue = "1") @NonNull BigInteger page,
            @RequestParam(name = QueryParamConstants.PER_PAGE, required = false, defaultValue = "50") @NonNull BigInteger perPage,
            @RequestParam(name = QueryParamConstants.FROM, required = false) ZonedDateTime from,
            @RequestParam(name = QueryParamConstants.TO, required = false) ZonedDateTime to
    );

    @GetExchange
    ProductResponse.Multiple listProducts();

    @GetExchange("/{id}")
    ProductResponse.Single fetchProduct(@PathVariable(name = "id") String id);

    @PutExchange("/{id}")
    ProductResponse.Single updateProduct(@PathVariable(name = "id") String id, @RequestBody CreateOrUpdateProductRequest body);
}
