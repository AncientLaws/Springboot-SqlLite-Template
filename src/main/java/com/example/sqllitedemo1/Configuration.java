package com.example.sqllitedemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @Autowired
    Environment env;

//    This method of creating a datasource is fine for testing, but not for full scale applications as it recreates the connection everytime
//    @Bean
//    public DataSource dataSource() {
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("username"));
//        dataSource.setPassword(env.getProperty("password"));
//        return dataSource;
//    }


//    Better method of building a datasource
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSource = DataSourceBuilder.create();
            dataSource.driverClassName(env.getProperty("spring.datasource.driver-class-name"));
            dataSource.url(env.getProperty("spring.datasource.url"));
            dataSource.username(env.getProperty("username"));
            dataSource.password(env.getProperty("password"));
        return dataSource.build();
    }


//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.sqlite.JDBC");
//        dataSource.setUsername("admin");
//        dataSource.setPassword("admin");
//        dataSource.setUrl(
//                "jdbc:sqlite:spring.db");
//
//        return dataSource;
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
