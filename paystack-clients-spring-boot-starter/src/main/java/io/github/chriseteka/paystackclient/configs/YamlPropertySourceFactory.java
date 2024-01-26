package io.github.chriseteka.paystackclient.configs;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.Properties;

@Configuration
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @NonNull
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());

        Properties properties = factory.getObject();

        assert properties != null;
        return new PropertiesPropertySource(Objects.requireNonNull(encodedResource.getResource().getFilename()), properties);
    }
}
