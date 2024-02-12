package com.example.sqllitedemo1.database.Dao;

import com.example.sqllitedemo1.database.Entity.Testdb;
import com.example.sqllitedemo1.database.Repository.TestDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class TestDbDao {

    @Autowired
    private final TestDbRepository testDbRepository;

    public TestDbDao(TestDbRepository testDbRepository) {
        this.testDbRepository = testDbRepository;
    }

    @Transactional
    public Iterable<Testdb> findAll(){
        return testDbRepository.findAll();
    }
    @Transactional
    public Optional<Testdb> findById(Long i){
        return testDbRepository.findById(i);
    }
    @Transactional
    public Testdb add(Testdb testDb){
        return testDbRepository.save(testDb);
    }
    @Transactional
    public Testdb update(Testdb testdb){
        return testDbRepository.save(testdb);
    }
    @Transactional
    public void delete(Testdb testdb){
         testDbRepository.delete(testdb);
    }
    @Transactional
    public long getTestDbSequence(){
       return testDbRepository.findTopByOrderByIdDesc().getId();
    }

}
