package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LikeRepository {

    @PersistenceContext
    private EntityManager manager;


    public void save(Like like) {

        // persist ;  manager 를 통해 만들어 놓은것들 저장
        manager.persist(like);
    }
}
