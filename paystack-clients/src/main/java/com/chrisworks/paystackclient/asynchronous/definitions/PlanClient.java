package com.chrisworks.paystackclient.asynchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.Create;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.FetchByIdOrCode;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.FetchMultiple;
import com.chrisworks.paystackclient.asynchronous.definitions.Operations.UpdateByIdOrCode;
import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanListQueryParam;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.OkHttpClient;

import java.util.concurrent.CompletionStage;

public interface PlanClient extends
        Create<CreatePlanRequest, PlanResponse.Single>,
        FetchMultiple<PlanListQueryParam, PlanResponse.Multiple>,
        FetchByIdOrCode<PlanResponse.Single>,
        UpdateByIdOrCode<UpdatePlanRequest, PlanResponse.Single> {

    final class Impl extends WithConfiguredHttpClient implements PlanClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public CompletionStage<RichResponse<PlanResponse.Single>> create(CreatePlanRequest body) {
            return null;
        }

        @Override
        public CompletionStage<RichResponse<PlanResponse.Multiple>> fetchMultiple(PlanListQueryParam queryParam) {
            return null;
        }

        @Override
        public CompletionStage<RichResponse<PlanResponse.Single>> fetchByIdOrCode(String idOrCode) {
            return null;
        }

        @Override
        public CompletionStage<RichResponse<PlanResponse.Single>> updateByIdOrCode(String idOrCode, UpdatePlanRequest body) {
            return null;
        }
    }
}
