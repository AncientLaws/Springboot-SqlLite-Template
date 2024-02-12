package com.example.sqllitedemo1;

import com.example.sqllitedemo1.database.Entity.Testdb;
import com.example.sqllitedemo1.database.Repository.TestDbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SqlliteTemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestDbRepository testDbRepository;

    @Test
    public void testSaveAndRetrieve() {
        // Create a new Testdb entity
        Testdb testDb = new Testdb();
        testDb.setValue("Test Value1");

        // Save the entity
        testDbRepository.save(testDb);

        // Retrieve the entity
        Testdb foundTestDb = testDbRepository.findById(testDb.getId()).orElse(null);

        // Assertions
        assertNotNull(foundTestDb, "Entity should not be null");
        assertEquals("Test Value1", foundTestDb.getValue(), "The value should match");
    }

}
