package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanListQueryParam;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public interface PlanClient {

    ExecutionSpec<PlanResponse.Single> createPlan(CreatePlanRequest body);
    ExecutionSpec<PlanResponse.Multiple> listPlans(PlanListQueryParam queryParam);
    ExecutionSpec<PlanResponse.Single> fetchPlan(@NotNull String idOrCode);
    ExecutionSpec<PlanResponse.Single> updatePlan(@NotNull String idOrCode, UpdatePlanRequest body);

    final class Impl extends WithConfiguredHttpClient implements PlanClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<PlanResponse.Single> createPlan(CreatePlanRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, PlanResponse.Single.class);
        }

        @Override
        public ExecutionSpec<PlanResponse.Multiple> listPlans(PlanListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, PlanResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<PlanResponse.Single> fetchPlan(@NotNull String idOrCode) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BY_ID_OR_CODE.apply(idOrCode))
                    .get()
                    .build();

            return execSpec(request, PlanResponse.Single.class);
        }

        @Override
        public ExecutionSpec<PlanResponse.Single> updatePlan(@NotNull String idOrCode, UpdatePlanRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Plan.BY_ID_OR_CODE.apply(idOrCode))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, PlanResponse.Single.class);
        }
    }
}
