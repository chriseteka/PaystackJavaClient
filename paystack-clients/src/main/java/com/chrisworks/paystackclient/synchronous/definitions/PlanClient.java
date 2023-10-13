package com.chrisworks.paystackclient.synchronous.definitions;

import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanListQueryParam;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public interface PlanClient extends
        Operations.Create<CreatePlanRequest, PlanResponse.Single>,
        Operations.FetchMultiple<PlanListQueryParam, PlanResponse.Multiple>,
        Operations.FetchByIdOrCode<PlanResponse.Single>,
        Operations.UpdateByIdOrCode<UpdatePlanRequest, PlanResponse.Single> {

    final class Impl extends WithConfiguredHttpClient implements PlanClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public RichResponse<PlanResponse.Single> create(CreatePlanRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execute(request, PlanResponse.Single.class);
        }

        @Override
        public RichResponse<PlanResponse.Multiple> fetchMultiple(PlanListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execute(request, PlanResponse.Multiple.class);
        }

        @Override
        public RichResponse<PlanResponse.Single> fetchByIdOrCode(String idOrCode) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BY_ID_OR_CODE.apply(idOrCode))
                    .get()
                    .build();

            return execute(request, PlanResponse.Single.class);
        }

        @Override
        public RichResponse<PlanResponse.Single> updateByIdOrCode(String idOrCode, UpdatePlanRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BY_ID_OR_CODE.apply(idOrCode))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execute(request, PlanResponse.Single.class);
        }
    }
}
