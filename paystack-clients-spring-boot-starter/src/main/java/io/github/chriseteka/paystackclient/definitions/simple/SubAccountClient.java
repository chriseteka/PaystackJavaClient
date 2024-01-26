package io.github.chriseteka.paystackclient.definitions.simple;

import io.github.chriseteka.paystackclient.definitions.Constants;
import io.github.chriseteka.paystackclient.domain.request.QueryParamConstants;
import io.github.chriseteka.paystackclient.domain.subaccount.CreateSubAccountRequest;
import io.github.chriseteka.paystackclient.domain.subaccount.SubAccountResponse;
import io.github.chriseteka.paystackclient.domain.subaccount.UpdateSubAccountRequest;
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

@HttpClient(Constants.SUB_ACCOUNT_CLIENT)
public interface SubAccountClient {

    @PostExchange
    SubAccountResponse.Single createSubAccount(@RequestBody CreateSubAccountRequest body);

    @GetExchange
    SubAccountResponse.Multiple listSubAccounts(
            @RequestParam(name = QueryParamConstants.PAGE, required = false, defaultValue = "1") @NonNull BigInteger page,
            @RequestParam(name = QueryParamConstants.PER_PAGE, required = false, defaultValue = "50") @NonNull BigInteger perPage,
            @RequestParam(name = QueryParamConstants.FROM, required = false) ZonedDateTime from,
            @RequestParam(name = QueryParamConstants.TO, required = false) ZonedDateTime to
    );

    @GetExchange
    SubAccountResponse.Multiple listSubAccounts();

    @GetExchange("/{idOrCode}")
    SubAccountResponse.Single fetchSubAccount(@PathVariable(name = "idOrCode") String idOrCode);

    @PutExchange("/{idOrCode}")
    SubAccountResponse.Single updateSubAccount(@PathVariable(name = "idOrCode") String idOrCode, @RequestBody UpdateSubAccountRequest body);
}
