package project.app.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PropertiesConfig {

    private final static String APPLICATION_PROPERTIES = "application.properties";
    private final static String APPLICATION_CONFIG_PROPERTIES = "application.config.properties";

    @Bean
    public PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
        propertyConfigurer.setIgnoreResourceNotFound(true);

        final List<Resource> resourceLst = new ArrayList<>();
        resourceLst.add(new ClassPathResource(APPLICATION_PROPERTIES));
        resourceLst.add(new ClassPathResource(APPLICATION_CONFIG_PROPERTIES));

        propertyConfigurer.setLocations(resourceLst.toArray(new Resource[]{}));
        return propertyConfigurer;
    }
}
