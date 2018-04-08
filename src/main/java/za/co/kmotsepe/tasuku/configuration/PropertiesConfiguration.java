package za.co.kmotsepe.tasuku.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Kingsley Motsepe
 */
@Configuration
public class PropertiesConfiguration {
 
    @Bean
    public PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = 
                new PropertyPlaceholderConfigurer();

        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);

        final List<Resource> resourceLst = new ArrayList<>();

        resourceLst.add(new ClassPathResource("application.environment.properties"));

        propertyPlaceholderConfigurer.setLocations(resourceLst.toArray(new Resource[]{}));

        return propertyPlaceholderConfigurer;
    }
}
