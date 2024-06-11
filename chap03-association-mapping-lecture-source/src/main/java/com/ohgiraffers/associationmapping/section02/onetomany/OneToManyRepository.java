package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OneToManyRepository {

    @PersistenceContext
    private EntityManager entitymanager;

    public Category find(int categoryCode) {

        return entitymanager.find(Category.class, categoryCode);
    }

    public void regist(Category category) {

        entitymanager.persist(category);
    }
}
