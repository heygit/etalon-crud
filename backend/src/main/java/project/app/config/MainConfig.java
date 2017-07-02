package project.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import project.dao.impl.CustomRepositoryImpl;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"project.controller", "project.service", "project.dao"})
@EntityScan("project")
@EnableJpaRepositories(value = "project.dao", repositoryBaseClass = CustomRepositoryImpl.class)
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class MainConfig {

}