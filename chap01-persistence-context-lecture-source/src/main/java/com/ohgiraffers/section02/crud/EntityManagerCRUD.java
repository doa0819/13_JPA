package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;




public class EntityManagerCRUD {

    private EntityManager manager;

    public EntityManager getManagerInstance() {

        return manager;
    }

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();

        // Menu.class 에서 menuCode 를 기반으로 찾을거다
        return manager.find(Menu.class, menuCode);


    }

    public Long saveAndReturnAllCount(Menu newMenu) {

        manager = EntityManagerGenerator.getManagerInstance();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(newMenu);
        manager.flush();

        return getCount(manager);
    }

    private Long getCount(EntityManager manager){

        return manager.createQuery("SELECT COUNT(*) FROM section02Menu", Long.class).getSingleResult();
    }

    public Menu modifyMenuName(int menuCode, String menuName) {

        Menu foundMenu = findMenuByMenuCode(menuCode);

        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        foundMenu.setMenuName(menuName);

        manager.flush();

        return foundMenu;
    }

    public Long removeAndReturnAllCount(int menuCode) {

        // 하나의 행을 찾음
        Menu foundMenu = findMenuByMenuCode(menuCode);

        // transaction 열어주고
        EntityTransaction transaction =manager.getTransaction();

        transaction.begin();

        // 하나의 행 삭제
        manager.remove(foundMenu);

        //flush() : 데이터베이스에 반영
        manager.flush();

        return getCount(manager);


    }
}
