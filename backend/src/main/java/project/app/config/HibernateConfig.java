package project.app.config;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class HibernateConfig extends HibernateJpaAutoConfiguration {

    public HibernateConfig(DataSource dataSource, JpaProperties jpaProperties, ObjectProvider<JtaTransactionManager> jtaTransactionManager, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        super(dataSource, jpaProperties, jtaTransactionManager, transactionManagerCustomizers);
    }

    @Bean
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        final LocalContainerEntityManagerFactoryBean ret = super.entityManagerFactory(factoryBuilder);
        ret.setMappingResources("orm.xml");
        return ret;
    }
}