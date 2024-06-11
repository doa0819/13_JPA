package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @Autowired
    private EntityManager manager;

    public String selectSingleMenuByTypedQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";
        TypedQuery<String> query = manager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();

        return resultMenuName;

    }

    public Menu findMenu(int menuCode) {

        return manager.find(Menu.class, menuCode);

    }

    public Object selectSingleMenuByQuery() {

        String jpql = "SELECT m.menuName FROM section01Menu m WHERE m.menuCode = 8";
        Query query = manager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();

        return resultMenuName;
    }

    public Menu selectSingleRowByTypedQuery() {

        String jpql = "SELECT m FROM section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);
        // getSingleResult -> 혼자 일때
        Menu resultMenu = query.getSingleResult();

        return resultMenu;
    }

    public List<Menu> selectMultiRowByTypedQuery() {

        String jpql = "SELECT m FROM section01Menu m";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);
        //getResultList -> List 일때
        List<Menu> resultMenuList = query.getResultList();

        return resultMenuList;
    }

    public List<Menu> selectMultiRowByQuery() {

        String jpql = "SELECT m FROM section01Menu m";
        Query query = manager.createQuery(jpql);

        List<Menu> resultMenuList = query.getResultList();

        return resultMenuList;
    }

    public List<Integer> selectUseDistinct() {

        // section01Menu 에서 categoryCode 를 조회를 하는데 중복된 것은 제외를 한다.
        String jpql = "SELECT DISTINCT m.categoryCode FROM section01Menu m";
//        String jpql = "SELECT DISTINCT m.categoryCode FROM section01Menu m WHERE m.categoryCode IN (11, 20)";

        TypedQuery<Integer> query = manager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryCodeList = query.getResultList();

        return resultCategoryCodeList;
    }
}