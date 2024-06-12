package com.ohgiraffers.jpql.section06.projection;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionService {


    private ProjectionRepository repository;

    public ProjectionService(ProjectionRepository repository){
        this.repository = repository;
    }

    // @Transactional 붙였을때 출력문이 update 위에 뜨고 아니면 update 아래뜬다
    // -> 즉 이말은 영속성컨테스트   @PersistenceContext 가 엔티티에 대한 정보를 다 알고 담고 있다


    @Transactional
    public List<Menu> singleEntityTest() {

        // 1. 메뉴에 대한거 전체 리스트 검색
        // 2. 메뉴 1 번에 대한 것 검색

        List<Menu>menuList = repository.singleEntityTest();

        // 메뉴코드 1번에 대한것 조회
        Menu menu = repository.findMenu(1);
        System.out.println("menu = " + menu);

        // update
        menuList.get(7).setMenuName("새로운 이름");

        return menuList;
    }

    @Transactional
    public BiDirectionCategory biDirectionProjection(int menuCode) {

        BiDirectionCategory categoryOfMenu = repository.biDirectionProjection(menuCode);
        categoryOfMenu.getMenuList().forEach(System.out::println);

        return categoryOfMenu;
    }
}
