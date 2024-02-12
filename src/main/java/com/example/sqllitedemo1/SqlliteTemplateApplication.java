package com.example.sqllitedemo1;

import com.example.sqllitedemo1.database.Dao.TestDbDao;
import com.example.sqllitedemo1.database.Entity.Testdb;
import com.example.sqllitedemo1.database.Repository.TestDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SqlliteTemplateApplication{

    public static void main(String[] args) {
        SpringApplication.run(SqlliteTemplateApplication.class, args);

    }

}
