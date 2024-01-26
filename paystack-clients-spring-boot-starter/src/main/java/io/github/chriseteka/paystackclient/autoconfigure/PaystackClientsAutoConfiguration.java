package io.github.chriseteka.paystackclient.autoconfigure;

import io.github.chriseteka.paystackclient.configs.PaystackClientsProperties;
import io.github.chriseteka.paystackclient.configs.YamlPropertySourceFactory;
import io.github.chriseteka.paystackclient.definitions.ReactivePaystackClient;
import io.github.chriseteka.paystackclient.definitions.SimplePaystackClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(PaystackClientsProperties.class)
@ConditionalOnProperty(prefix = "paystack-client", name = "secret-key")
@PropertySource(value = "classpath:application-paystack-clients-config.yml", factory = YamlPropertySourceFactory.class)
public class PaystackClientsAutoConfiguration {

    /**
     * Non Reactive Client configuration
     */
    @Configuration
    @ConditionalOnProperty(prefix = "paystack-client", name = "definition-type", havingValue = "NON_REACTIVE", matchIfMissing = true)
    @ComponentScan(basePackageClasses = SimplePaystackClient.class)
    public static class NonReactiveClientConfiguration {
        public static final String ROOT = "io.github.chriseteka.paystackclient.definitions.simple";
    }

    /**
     * Reactive Client configuration
     */
    @Configuration
    @ConditionalOnProperty(prefix = "paystack-client", name = "definition-type", havingValue = "REACTIVE")
    @ComponentScan(basePackageClasses = ReactivePaystackClient.class)
    public static class ReactiveClientConfiguration {
        public static final String ROOT = "io.github.chriseteka.paystackclient.definitions.reactive";
    }
}
