package com.example.sqllitedemo1;

import com.example.sqllitedemo1.database.Dao.TestDbDao;
import com.example.sqllitedemo1.database.Entity.Testdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainController implements CommandLineRunner {

    @Autowired
    TestDbDao testDbDao;

    @Override
    public void run(String... args) throws Exception {
        Testdb testDb = new Testdb();

        testDb.setValue("Hello 123");
        boolean saveStatus = testDbDao.add(testDb)!=null;

        if(saveStatus){
            Iterable<Testdb> testDbList = testDbDao.findAll();


            System.out.println("Saved! "  + testDb.getValue().toString());

            System.out.println(testDb);
        }

    }
}
