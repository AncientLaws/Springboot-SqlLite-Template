package com.example.sqllitedemo1.database.Dao;

import com.example.sqllitedemo1.database.Entity.TestEntity;
import com.example.sqllitedemo1.database.Repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class TestEntityDao {

    @Autowired
    private final TestEntityRepository testEntityRepository;

    public TestEntityDao(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    @Transactional
    public Iterable<TestEntity> findAll(){
        return testEntityRepository.findAll();
    }
    @Transactional
    public Optional<TestEntity> findById(Long i){
        return testEntityRepository.findById(i);
    }
    @Transactional
    public TestEntity add(TestEntity testDb){
        return testEntityRepository.save(testDb);
    }
    @Transactional
    public TestEntity update(TestEntity testEntity){
        return testEntityRepository.save(testEntity);
    }
    @Transactional
    public void delete(TestEntity testEntity){
         testEntityRepository.delete(testEntity);
    }
    @Transactional
    public long getTestDbSequence(){
       return testEntityRepository.findTopByOrderByIdDesc().getId();
    }

}
