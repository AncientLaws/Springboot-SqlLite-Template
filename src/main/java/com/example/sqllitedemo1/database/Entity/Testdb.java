package com.example.sqllitedemo1.database.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "test")
@Component
public class Testdb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="value", nullable = true)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Testdb(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Testdb() {
        System.out.println("Initializled Entity testdb.java");
    }
}
