package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.transaction.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public interface TransactionClient {

    ExecutionSpec<InitTransactionResponse.Single> initializeTransaction(InitTransactionRequest body);
    ExecutionSpec<TransactionResponse.Single> verifyTransaction(@NotNull String reference);
    ExecutionSpec<TransactionResponse.Multiple> listTransaction(TransactionListQueryParam queryParam);
    ExecutionSpec<TransactionResponse.Single> fetchTransaction(@NotNull BigInteger id);
    ExecutionSpec<TransactionTotalResponse.Single> chargeAuthorization(ChargeAuthorizationRequest body);
    ExecutionSpec<TimeLineResponse.Single> viewTransactionTimeLine(@NotNull String idOrReference);
    ExecutionSpec<TransactionTotalResponse.Single> transactionTotals(TransactionTotalQueryParam queryParam);
    ExecutionSpec<ExportTransactionResponse.Single> exportTransactions(ExportTransactionQueryParam queryParam);
    ExecutionSpec<TransactionTotalResponse.Single> partialDebit(PartialDebitRequest body);

    final class Impl extends WithConfiguredHttpClient implements TransactionClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<InitTransactionResponse.Single> initializeTransaction(InitTransactionRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.INIT_TRANSACTION_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, InitTransactionResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TransactionResponse.Single> verifyTransaction(@NotNull String reference) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.VERIFY_TRANSACTION_URL.apply(reference))
                    .get()
                    .build();

            return execSpec(request, TransactionResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TransactionResponse.Multiple> listTransaction(TransactionListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, TransactionResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<TransactionResponse.Single> fetchTransaction(@NotNull BigInteger id) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.BY_ID.apply(String.valueOf(id)))
                    .get()
                    .build();

            return execSpec(request, TransactionResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TransactionTotalResponse.Single> chargeAuthorization(ChargeAuthorizationRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.CHARGE_AUTHORIZATION_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, TransactionTotalResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TimeLineResponse.Single> viewTransactionTimeLine(@NotNull String idOrReference) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.VIEW_TIMELINE_URL.apply(idOrReference))
                    .get()
                    .build();

            return execSpec(request, TimeLineResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TransactionTotalResponse.Single> transactionTotals(TransactionTotalQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.TOTAL_TRANSACTION_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, TransactionTotalResponse.Single.class);
        }

        @Override
        public ExecutionSpec<ExportTransactionResponse.Single> exportTransactions(ExportTransactionQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.EXPORT_TRANSACTIONS_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, ExportTransactionResponse.Single.class);
        }

        @Override
        public ExecutionSpec<TransactionTotalResponse.Single> partialDebit(PartialDebitRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Transaction.PARTIAL_DEBIT_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, TransactionTotalResponse.Single.class);
        }
    }
}
