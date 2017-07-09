package project.config.profiles;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import project.filter.SecurityFilter;

import static project.constants.ParamValues.ALL_URLS_PATTERN;

@Configuration
@Profile("production")
public class ProductionProfileConfig {

    @Bean
    public FilterRegistrationBean registerSecurityFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SecurityFilter());
        registration.addUrlPatterns(ALL_URLS_PATTERN);
        registration.setName(SecurityFilter.class.getSimpleName());
        registration.setOrder(1);
        return registration;
    }

}
