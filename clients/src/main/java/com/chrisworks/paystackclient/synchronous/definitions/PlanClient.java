package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanListRequest;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
import okhttp3.OkHttpClient;

public interface PlanClient extends
        Operations.Create<CreatePlanRequest, PlanResponse.Single>,
        Operations.FetchMultiple<PlanListRequest, PlanResponse.Multiple>,
        Operations.FetchByIdOrCode<PlanResponse.Single>,
        Operations.UpdateByIdOrCode<UpdatePlanRequest, PlanResponse.Single> {

    final class Impl extends WithConfiguredHttpClient implements PlanClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public PlanResponse.Single create(CreatePlanRequest body) {
            return null;
        }

        @Override
        public PlanResponse.Multiple fetchMultiple(PlanListRequest body) {
            return null;
        }

        @Override
        public PlanResponse.Single fetchByIdOrCode(String idOrCode) {
            return null;
        }

        @Override
        public PlanResponse.Single updateByIdOrCode(String idOrCode, UpdatePlanRequest body) {
            return null;
        }
    }
}
