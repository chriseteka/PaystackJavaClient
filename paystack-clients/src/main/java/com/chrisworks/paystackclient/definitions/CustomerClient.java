package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Email;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.customer.*;
import com.chrisworks.paystackclient.domain.response.EmptyDataResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public interface CustomerClient {

    ExecutionSpec<CustomerResponse.Single> createCustomer(CreateCustomerRequest body);
    ExecutionSpec<CustomerResponse.Multiple> listCustomers(CustomerListQueryParam queryParam);
    ExecutionSpec<DetailedCustomerResponse.Single> fetchCustomer(@NotNull String customerCode);
    default ExecutionSpec<DetailedCustomerResponse.Single> fetchCustomer(@NotNull Email customerEmail) {
        return fetchCustomer(customerEmail.value());
    }
    ExecutionSpec<DetailedCustomerResponse.Single> updateCustomer(String customerCode, UpdateCustomerRequest body);
    ExecutionSpec<EmptyDataResponse> validateCustomer(String customerCode, ValidateCustomerRequest body);
    default ExecutionSpec<EmptyDataResponse> validateCustomer(Email customerEmail, ValidateCustomerRequest body) {
        return validateCustomer(customerEmail.value(), body);
    }
    ExecutionSpec<CustomerResponse.Single> whiteOrBlackListCustomer(WhiteOrBlackListCustomerRequest body);
    ExecutionSpec<EmptyDataResponse> deactivateAuthorization(DeactivateAuthorizationRequest body);

    final class Impl extends WithConfiguredHttpClient implements CustomerClient {
        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<CustomerResponse.Single> createCustomer(CreateCustomerRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, CustomerResponse.Single.class);
        }

        @Override
        public ExecutionSpec<CustomerResponse.Multiple> listCustomers(CustomerListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, CustomerResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<DetailedCustomerResponse.Single> fetchCustomer(@NotNull String customerCode) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.BY_CUSTOMER_CODE_OR_EMAIL.apply(customerCode))
                    .get()
                    .build();

            return execSpec(request, DetailedCustomerResponse.Single.class);
        }

        @Override
        public ExecutionSpec<DetailedCustomerResponse.Single> updateCustomer(String customerCode, UpdateCustomerRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.BY_CUSTOMER_CODE_OR_EMAIL.apply(customerCode))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, DetailedCustomerResponse.Single.class);
        }

        @Override
        public ExecutionSpec<EmptyDataResponse> validateCustomer(String customerCode, ValidateCustomerRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.VALIDATE_CUSTOMER_URL.apply(customerCode))
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, EmptyDataResponse.class);
        }

        @Override
        public ExecutionSpec<CustomerResponse.Single> whiteOrBlackListCustomer(WhiteOrBlackListCustomerRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.WHITE_OR_BLACK_LIST_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, CustomerResponse.Single.class);
        }

        @Override
        public ExecutionSpec<EmptyDataResponse> deactivateAuthorization(DeactivateAuthorizationRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Customer.DEACTIVATE_AUTHORIZATION_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, EmptyDataResponse.class);
        }
    }
}
