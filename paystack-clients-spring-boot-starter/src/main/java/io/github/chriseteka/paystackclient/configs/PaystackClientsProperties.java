package io.github.chriseteka.paystackclient.configs;

import io.github.chriseteka.paystackclient.SupportedClient;
import io.github.chriseteka.paystackclient.definitions.DefinitionType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.Set;

@ConfigurationProperties(PaystackClientsProperties.PREFIX)
public class PaystackClientsProperties {

    public static final String PREFIX = "paystack-client";
    public static final String DEFINITION_TYPE = PREFIX + ".definition-type";
    public static final String ACTIVATED_CLIENTS_PATH = PREFIX + ".activate-only-clients";


    private String secretKey;
    private DefinitionType definitionType = DefinitionType.NON_REACTIVE;
    private Set<SupportedClient> activateOnlyClients = Collections.emptySet();

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public DefinitionType getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(DefinitionType definitionType) {
        this.definitionType = definitionType;
    }

    public Set<SupportedClient> getActivateOnlyClients() {
        return activateOnlyClients;
    }

    public void setActivateOnlyClients(Set<SupportedClient> activateOnlyClients) {
        this.activateOnlyClients = activateOnlyClients;
    }
}
