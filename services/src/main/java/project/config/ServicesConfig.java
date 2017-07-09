package project.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import project.dao.impl.CustomRepositoryImpl;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"project.service", "project.dao"})
@EntityScan("project")
@EnableJpaRepositories(value = "project.dao", repositoryBaseClass = CustomRepositoryImpl.class)
@PropertySource("classpath:services.properties")
@EnableTransactionManagement
public class ServicesConfig {

}