package com.example.sqllitedemo1;

import com.example.sqllitedemo1.database.Entity.TestEntity;
import com.example.sqllitedemo1.database.Repository.TestEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SqlliteTemplateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void testSaveAndRetrieve() {
        // Create a new Testdb entity
        TestEntity testEntity = new TestEntity();
        testEntity.setValue("Record 16");

        // Save the entity
        testEntityRepository.save(testEntity);

        // Retrieve the entity
        TestEntity foundTestDb = testEntityRepository.findById(testEntity.getId()).orElse(null);

        // Assertions
        assertNotNull(foundTestDb, "Entity should not be null");
        assertEquals("Record 16", foundTestDb.getValue(), "The value should match");

        // Delete the record
        testEntityRepository.delete(foundTestDb);

        // Retrieve the entity
        TestEntity testEntityShouldBeNull = testEntityRepository.findById(foundTestDb.getId()).orElse(null);

        assertNull(testEntityShouldBeNull,"Entity should be done because it was deleted");
    }

}
