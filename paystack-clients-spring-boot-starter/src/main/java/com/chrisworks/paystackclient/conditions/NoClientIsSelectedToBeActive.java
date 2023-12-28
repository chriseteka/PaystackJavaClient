package com.chrisworks.paystackclient.conditions;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

import java.util.Arrays;

import static com.chrisworks.paystackclient.configs.PaystackClientsProperties.ACTIVATED_CLIENTS_PATH;

public class NoClientIsSelectedToBeActive implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {

        return ((ConfigurableEnvironment) context.getEnvironment()).getPropertySources()
                .stream()
                .<String[]>mapMulti((a, b) -> {
                    if (a instanceof MapPropertySource mapPropertySource) {
                        b.accept(mapPropertySource.getPropertyNames());
                    }
                })
                .flatMap(Arrays::stream)
                .noneMatch(k -> k.startsWith(ACTIVATED_CLIENTS_PATH));
    }

    @NonNull
    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }
}
