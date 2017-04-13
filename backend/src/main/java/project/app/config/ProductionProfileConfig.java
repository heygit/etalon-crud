package project.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
@ComponentScan("project.services.impl")
public class ProductionProfileConfig {

}
