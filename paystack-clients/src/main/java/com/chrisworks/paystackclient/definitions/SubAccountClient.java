package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.subaccount.CreateSubAccountRequest;
import com.chrisworks.paystackclient.domain.subaccount.SubAccountListQueryParam;
import com.chrisworks.paystackclient.domain.subaccount.SubAccountResponse;
import com.chrisworks.paystackclient.domain.subaccount.UpdateSubAccountRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public interface SubAccountClient {

    ExecutionSpec<SubAccountResponse.Single> createSubAccount(CreateSubAccountRequest body);

    ExecutionSpec<SubAccountResponse.Multiple> listSubAccounts(SubAccountListQueryParam queryParam);

    ExecutionSpec<SubAccountResponse.Single> fetchSubAccount(@NotNull String idOrCode);

    ExecutionSpec<SubAccountResponse.Single> updateSubAccount(@NotNull String idOrCode, UpdateSubAccountRequest body);

    final class Impl extends WithConfiguredHttpClient implements SubAccountClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<SubAccountResponse.Single> createSubAccount(CreateSubAccountRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.SubAccount.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, SubAccountResponse.Single.class);
        }

        @Override
        public ExecutionSpec<SubAccountResponse.Multiple> listSubAccounts(SubAccountListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.SubAccount.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, SubAccountResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<SubAccountResponse.Single> fetchSubAccount(@NotNull String idOrCode) {
            final Request request = new Request.Builder()
                    .url(Routes.SubAccount.BY_ID_OR_CODE.apply(idOrCode))
                    .get()
                    .build();

            return execSpec(request, SubAccountResponse.Single.class);
        }

        @Override
        public ExecutionSpec<SubAccountResponse.Single> updateSubAccount(@NotNull String idOrCode,
                                                                         UpdateSubAccountRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.SubAccount.BY_ID_OR_CODE.apply(idOrCode))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, SubAccountResponse.Single.class);
        }
    }
}
