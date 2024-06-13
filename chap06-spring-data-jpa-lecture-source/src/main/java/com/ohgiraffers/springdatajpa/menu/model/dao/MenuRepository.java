package com.ohgiraffers.springdatajpa.menu.model.dao;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/* 필기.
*   JpaRepository 상속 받을 것이다. (<내가 사용할 엔티티, 해당클래스의 아이디값>)
*   Repository <- CrudRepository <- PagingAndSortRepository <- JpaRepository
*   - EntityMangerFactory, EntityManager, EntityTransaction 자동구현
*   (JpaRepository<Menu, Integer> : Menu -> class, Integer -> 그 class 의 Id 가 붙은 컬럼의 자료형(인스턴스화한) )
* */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {


    List<Menu> findByMenuPriceGreaterThan(int menuPrice);

    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(int menuPrice);

    List<Menu> findByMenuPriceGreaterThan(int menuPrice, Sort menuPrice1);
}
