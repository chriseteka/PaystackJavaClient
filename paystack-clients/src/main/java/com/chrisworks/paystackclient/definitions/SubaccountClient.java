package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.subaccount.CreateSubaccountRequest;
import com.chrisworks.paystackclient.domain.subaccount.SubaccountListQueryParam;
import com.chrisworks.paystackclient.domain.subaccount.SubaccountResponse;
import com.chrisworks.paystackclient.domain.subaccount.UpdateSubaccountRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public interface SubaccountClient {

    ExecutionSpec<SubaccountResponse.Single> createSubaccount(CreateSubaccountRequest body);

    ExecutionSpec<SubaccountResponse.Multiple> listSubaccounts(SubaccountListQueryParam queryParam);

    ExecutionSpec<SubaccountResponse.Single> fetchSubaccount(@NotNull String idOrCode);

    ExecutionSpec<SubaccountResponse.Single> updateSubaccount(@NotNull String idOrCode, UpdateSubaccountRequest body);

    final class Impl extends WithConfiguredHttpClient implements SubaccountClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<SubaccountResponse.Single> createSubaccount(CreateSubaccountRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Subaccount.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, SubaccountResponse.Single.class);
        }

        @Override
        public ExecutionSpec<SubaccountResponse.Multiple> listSubaccounts(SubaccountListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Subaccount.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, SubaccountResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<SubaccountResponse.Single> fetchSubaccount(@NotNull String idOrCode) {
            final Request request = new Request.Builder()
                    .url(Routes.Subaccount.BY_ID_OR_CODE.apply(idOrCode))
                    .get()
                    .build();

            return execSpec(request, SubaccountResponse.Single.class);
        }

        @Override
        public ExecutionSpec<SubaccountResponse.Single> updateSubaccount(@NotNull String idOrCode,
                                                                         UpdateSubaccountRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Subaccount.BY_ID_OR_CODE.apply(idOrCode))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, SubaccountResponse.Single.class);
        }
    }
}
