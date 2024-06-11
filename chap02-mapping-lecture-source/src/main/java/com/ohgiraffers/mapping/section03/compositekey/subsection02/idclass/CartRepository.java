package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    @PersistenceContext
    private EntityManager manager;

    // insert 해줌
    public void save(Cart cart) {

        // manager 를 통해 전달해줌
        manager.persist(cart);
    }
}
