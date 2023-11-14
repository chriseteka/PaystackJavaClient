package com.chrisworks.paystackclient;


import com.chrisworks.paystackclient.domain.PaystackException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.function.Function;

public class PaystackClientConfiguration {

    private PaystackClientConfiguration() {
    }

    private static PaystackClient paystackClient = null;

    public static PaystackClient buildPaystackClientFrom(String secretKey) {

        if (paystackClient == null) {

            final SSLContext sslContext;
            try {
                sslContext = SSLContext.getInstance("TLSv1.2");
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
                    //intentional
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    //intentional
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }
    };
}
