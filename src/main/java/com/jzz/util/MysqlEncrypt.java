package com.jzz.util;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * @author:jzz
 * @date:2021/1/13
 */
@Configuration
@Component
public class MysqlEncrypt {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSourceProperties mysqlDataSourceProperties () {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    public HikariDataSource hikariDataSource () {
//        DataSourceProperties dataSourceProperties = mysqlDataSourceProperties();
//        dataSourceProperties.setPassword(AesEncryptUtils.decrypt(dataSourceProperties.getPassword()));
//        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }


    @Bean
    @Primary
    public HikariDataSource hikariDataSource (DataSourceProperties dataSourceProperties) {
        dataSourceProperties.setPassword(AesEncryptUtils.decrypt(dataSourceProperties.getPassword()));
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }




}
