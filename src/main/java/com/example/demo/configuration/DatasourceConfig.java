package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 19:58
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@Configuration
public class DatasourceConfig {
    @Value("${spring.datasource.db1.jndi-name}")
    private String db1JndiName;

    @Value("${spring.datasource.db2.jndi-name}")
    private String db2JndiName;

    @Primary
    @Bean("oracleDatasource")
    @Qualifier("oracleDatasource")
    public DataSource oracleDatasource(){
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(db1JndiName);
    }

    @Bean("mysqlDatasource")
    @Qualifier("mysqlDatasource")
    public DataSource mysqlDatasource(){
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource(db2JndiName);
    }
}
