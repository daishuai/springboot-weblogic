package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 20:30
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMysql",
        transactionManagerRef = "transactionManagerMysql",
        basePackages = {"com.example.demo.repository.mysql"})//设置Repository所在位置
public class MysqlConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("mysqlDatasource")
    private DataSource dataSource;


    @Bean(name = "entityManagerMysql")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
    @Bean(name = "entityManagerFactoryMysql")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(dataSource))
                .packages("com.example.demo.vo") //设置实体类所在位置
                .persistenceUnit("mysqlPersistenceUnit")
                .build();
    }

    private Map getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerMysql")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
