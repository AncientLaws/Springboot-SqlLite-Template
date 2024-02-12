package com.example.sqllitedemo1;

import com.example.sqllitedemo1.database.Dao.TestEntityDao;
import com.example.sqllitedemo1.database.Entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A template for a controller that can interact with the database
 * */
@Component
public class MainController implements CommandLineRunner {

    @Autowired
    TestEntityDao testEntityDao;

    /**
     * Run whatever you want here
     * */
    @Override
    public void run(String... args) throws Exception {
        runDatabaseTestRoutine(true);
    }


    /**
     * Test routine to see if updating and retreiving records from the database works
     * */
    public void runDatabaseTestRoutine(boolean run){
        if(run){
            TestEntity testEntity = new TestEntity();
            testEntity.setValue("Hello 123");

            TestEntity savedEntity = testEntityDao.add(testEntity);

            if(savedEntity != null){
                Optional<TestEntity> retrieveSavedRecord = testEntityDao.findById(savedEntity.getId());

                System.out.println("Record exists? "  + retrieveSavedRecord.isPresent());

                System.out.println(retrieveSavedRecord);
            }
            else{
                System.out.println("An error occurred while saving to the database");
            }
        }
    }
}
