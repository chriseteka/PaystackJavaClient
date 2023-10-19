package com.chrisworks.paystackclient;


import com.chrisworks.paystackclient.domain.PaystackException;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionTotalResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.function.Function;

public class PaystackClientConfiguration {

    private PaystackClientConfiguration() {
    }

    private static PaystackClient paystackClient = null;

    private static PaystackClient buildPaystackClientFrom(String secretKey) {

        if (paystackClient == null) {

            final SSLContext sslContext;
            try {
                sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                throw new PaystackException(e);
            }

            final Interceptor interceptor = enrichRequestWithAuth.apply(secretKey);

            final OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(Duration.ofSeconds(2))
                    .writeTimeout(Duration.ofSeconds(2))
                    .connectTimeout(Duration.ofSeconds(3))
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                    .addInterceptor(interceptor)
                    .build();

            paystackClient = new PaystackClient.Impl(client);
        }

        return paystackClient;
    }

    private static final Function<String, Interceptor> enrichRequestWithAuth = secret -> new Interceptor() {
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            return chain.proceed(
                    chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Authorization", "Bearer " + secret)
                            .build()
            );
        }
    };

    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }
    };

    public static void main(String[] args) {
        //Usage sample
        final PaystackClient client = PaystackClientConfiguration.buildPaystackClientFrom("<Your secret key here>");
//        RichResponse<PlanResponse.Single> res1 = client
//                .plan()
//                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
//                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)))
//                .execute();
//        System.out.println(res1);

//        Void res = client
//                .plan()
//                .fetchPlan("PLN_16x08vyy3bu2h7x")
//                .executeAsync()
//                .thenAccept(re -> System.out.println(re.result()))
//                .join();

        RichResponse<TransactionResponse.Single> transactions = client
                .transaction()
                .fetchTransaction(BigInteger.valueOf(3200117924L))
                .execute();

        RichResponse<TransactionTotalResponse.Single> total = client.transaction().transactionTotals(null).execute();


//        RichResponse<PlanResponse.Single> res2 = client
//                .plan()
//                .fetchPlan("PLN_16x08vyy3bu2h7x")
//                .execute();
        System.out.println(transactions);
        System.out.println(total);

//        String json = res.raw();
//        PlanResponse.Multiple result = res.result();
//        Map<String, Object> objectMap = res.rawJsonAsMap();
    }
}
