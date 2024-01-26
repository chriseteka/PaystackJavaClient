package com.maciejwalkowiak.spring.http.registration;

import io.github.chriseteka.paystackclient.SupportedClient;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.*;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.chriseteka.paystackclient.configs.PaystackClientsProperties.ACTIVATED_CLIENTS_PATH;

/**
 * Registers bean definitions for {@link WebClient}s defined in Spring {@link Environment} under prefix {@code "http.clients}.
 *
 * @author Maciej Walkowiak
 * @author Tigran Babloyan
 * @author chriseteka
 */
public class WebClientsRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final String PREFIX = "http.clients";
    private Environment environment;

    @Override
    public void registerBeanDefinitions(
            @NonNull AnnotationMetadata importingClassMetadata, @NonNull BeanDefinitionRegistry registry,
            @NonNull BeanNameGenerator importBeanNameGenerator) {
        if (!(environment instanceof ConfigurableEnvironment)) {
            return;
        }
        for (String clientName : resolveClientNames()) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(WebClientFactoryBean.class);
            builder.addPropertyValue("name", clientName);
            registry.registerBeanDefinition(clientName + ".WebClient", builder.getBeanDefinition());
        }
    }

    private Set<String> resolveClientNames() {
        final ConfigurableEnvironment env = (ConfigurableEnvironment) environment;
        final List<String> activatedClients = getActivatedClients();

        return env.getPropertySources().stream()
                .flatMap(WebClientsRegistrar::resolvePropertyNames)
                .filter(it -> it.startsWith(PREFIX))
                .map(it -> it.substring((PREFIX + ".").length()))
                .map(it -> it.substring(0, it.indexOf(".")))
                .filter(it -> activatedClients.isEmpty() || activatedClients.contains(it))
                .collect(Collectors.toSet());
    }

    private static Stream<String> resolvePropertyNames(PropertySource<?> it) {
        if (it instanceof EnumerablePropertySource<?>) {
            return Arrays.stream(((EnumerablePropertySource<?>) it).getPropertyNames());
        } else {
            return Stream.empty();
        }
    }

    private List<String> getActivatedClients() {

        return ((ConfigurableEnvironment) environment).getPropertySources()
                .stream()
                .<Map<String, Object>>mapMulti((a, b) -> {
                    if (a instanceof MapPropertySource mapPropertySource) {
                        b.accept(mapPropertySource.getSource());
                    }
                })
                .flatMap(a -> a.entrySet().parallelStream())
                .<String>mapMulti((kv, consumer) -> {
                    if (kv.getKey().startsWith(ACTIVATED_CLIENTS_PATH)) {
                        final String value = ((String) ((OriginTrackedValue) kv.getValue()).getValue()).toUpperCase();
                        if (value.contains(",")) {
                            Arrays.stream(value.split(","))
                                    .forEach(v -> consumer.accept(SupportedClient.valueOf(v.trim()).beanName()));
                        }
                        else {
                            consumer.accept(SupportedClient.valueOf(value).beanName());
                        }
                    }
                })
                .toList();
    }

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        this.environment = environment;
    }
}