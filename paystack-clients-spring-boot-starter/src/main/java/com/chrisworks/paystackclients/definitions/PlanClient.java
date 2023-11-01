package com.chrisworks.paystackclients.definitions;

import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
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

@HttpClient(Constants.PLAN_CLIENT)
public interface PlanClient {

    @PostExchange
    PlanResponse.Single createPlan(@RequestBody CreatePlanRequest body);

    @GetExchange
    PlanResponse.Multiple listPlans(
            @RequestParam(name = QueryParamConstants.PAGE) @NonNull BigInteger page,
            @RequestParam(name = QueryParamConstants.PER_PAGE) @NonNull BigInteger perPage,
            @RequestParam(name = QueryParamConstants.STATUS, required = false) String status,
            @RequestParam(name = QueryParamConstants.INTERVAL, required = false) String interval,
            @RequestParam(name = QueryParamConstants.AMOUNT, required = false) String amount
    );

    @GetExchange("/{idOrCode}")
    PlanResponse.Single fetchPlan(@PathVariable String idOrCode);

    @PutExchange("/{idOrCode}")
    PlanResponse.Single updatePlan(@PathVariable String idOrCode, @RequestBody UpdatePlanRequest body);
}
