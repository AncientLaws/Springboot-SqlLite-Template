package com.example.sqllitedemo1.database.Repository;

import com.example.sqllitedemo1.database.Entity.Testdb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestDbRepository extends CrudRepository<Testdb,Long> {

    <S extends Testdb> S save(S entity);

    <S extends Testdb> Iterable<S> saveAll(Iterable<S> entities);

    Optional<Testdb> findById(Long aLong);

    boolean existsById(Long aLong);

    Iterable<Testdb> findAll();

    Iterable<Testdb> findAllById(Iterable<Long> longs);

    long count();

    void deleteById(Long aLong);

    void delete(Testdb entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Testdb> entities);

    void deleteAll();

    Testdb findTopByOrderByIdDesc();
}
