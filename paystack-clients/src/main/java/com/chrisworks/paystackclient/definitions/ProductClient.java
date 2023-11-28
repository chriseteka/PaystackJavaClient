package com.chrisworks.paystackclient.definitions;

import com.chrisworks.paystackclient.ExecutionSpec;
import com.chrisworks.paystackclient.WithConfiguredHttpClient;
import com.chrisworks.paystackclient.domain.Routes;
import com.chrisworks.paystackclient.domain.product.CreateOrUpdateProductRequest;
import com.chrisworks.paystackclient.domain.product.ProductListQueryParam;
import com.chrisworks.paystackclient.domain.product.ProductResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public interface ProductClient {

    ExecutionSpec<ProductResponse.Single> createProduct(CreateOrUpdateProductRequest body);

    ExecutionSpec<ProductResponse.Multiple> listProducts(ProductListQueryParam queryParam);

    ExecutionSpec<ProductResponse.Single> fetchProduct(@NotNull String id);

    ExecutionSpec<ProductResponse.Single> updateProduct(@NotNull String id, CreateOrUpdateProductRequest body);

    final class Impl extends WithConfiguredHttpClient implements ProductClient {

        public Impl(OkHttpClient httpClient) {
            super(httpClient);
        }

        @Override
        public ExecutionSpec<ProductResponse.Single> createProduct(CreateOrUpdateProductRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Product.BASE_URL)
                    .post(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, ProductResponse.Single.class);
        }

        @Override
        public ExecutionSpec<ProductResponse.Multiple> listProducts(ProductListQueryParam queryParam) {
            final Request request = new Request.Builder()
                    .url(Routes.Product.BASE_URL + safeExtractQueryParams(queryParam))
                    .get()
                    .build();

            return execSpec(request, ProductResponse.Multiple.class);
        }

        @Override
        public ExecutionSpec<ProductResponse.Single> fetchProduct(@NotNull String id) {
            final Request request = new Request.Builder()
                    .url(Routes.Product.BY_ID.apply(id))
                    .get()
                    .build();

            return execSpec(request, ProductResponse.Single.class);
        }

        @Override
        public ExecutionSpec<ProductResponse.Single> updateProduct(@NotNull String id, CreateOrUpdateProductRequest body) {
            final Request request = new Request.Builder()
                    .url(Routes.Product.BY_ID.apply(id))
                    .put(RequestBody.create(body.json(), applicationJson))
                    .build();

            return execSpec(request, ProductResponse.Single.class);
        }
    }
}
