package com.example.sqllitedemo1.database.Repository;

import com.example.sqllitedemo1.database.Entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestEntityRepository extends CrudRepository<TestEntity,Long> {

    <S extends TestEntity> S save(S entity);

    <S extends TestEntity> Iterable<S> saveAll(Iterable<S> entities);

    Optional<TestEntity> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<TestEntity> findAll();

    Iterable<TestEntity> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(TestEntity entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends TestEntity> entities);

    void deleteAll();

    TestEntity findTopByOrderByIdDesc();
}
