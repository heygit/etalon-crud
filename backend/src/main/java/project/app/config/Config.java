package project.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableAutoConfiguration
@ComponentScan("project.controllers")
@PropertySource("classpath:application.properties")
public class Config {

}