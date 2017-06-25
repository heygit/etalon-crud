package project.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
@ComponentScan({"project.dao.stub"})
public class LocalProfileConfig {

}
