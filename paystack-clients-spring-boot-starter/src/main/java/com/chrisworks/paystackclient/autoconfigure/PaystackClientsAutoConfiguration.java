package com.chrisworks.paystackclient.autoconfigure;

import com.chrisworks.paystackclient.PaystackClientsProperties;
import com.chrisworks.paystackclient.YamlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
    @AutoConfigurationPackage(basePackages = "com.chrisworks.paystackclient.definitions.simple")
    public static class NonReactiveClientConfiguration {}

    /**
     * Reactive Client configuration
     */
    @Configuration
    @ConditionalOnProperty(prefix = "paystack-client", name = "definition-type", havingValue = "REACTIVE")
    @AutoConfigurationPackage(basePackages = "com.chrisworks.paystackclient.definitions.reactive")
    public static class ReactiveClientConfiguration {}
}
