package com.chrisworks.paystackclient;

import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.Interval;
import com.chrisworks.paystackclient.domain.PaystackException;
import com.chrisworks.paystackclient.domain.plan.CreatePlanRequest;
import com.chrisworks.paystackclient.domain.plan.PlanListQueryParam;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.Map;
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
        final PaystackClient client = PaystackClientConfiguration.buildPaystackClientFrom("Yay");
        RichResponse<PlanResponse.Single> res1 = client.synchronous()
                .plan()
                .create(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)));
        System.out.println(res1);

        RichResponse<PlanResponse.Multiple> res = client.synchronous()
                .plan()
                .fetchMultiple(new PlanListQueryParam(BigInteger.TEN, BigInteger.ONE)
                        .amount(Amount.actualValue(BigDecimal.valueOf(100_000)).ofCurrency(Currency.NGN))
                        .interval(Interval.BIANNUALLY)
                        .status("approved"));

        String json = res.raw();
        PlanResponse.Multiple result = res.result();
        Map<String, Object> objectMap = res.rawJsonAsMap();
    }
}
