package com.ohgiraffers.springdatajpa.menu.model.dao;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    // 네이티브 쿼리 : 실제 데이터베이스에 존재하는 컬럼명으로 쿼리문 작성
    // 데이터베이스안에 있는 카테고리를 조회
    @Query(value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code"
                    , nativeQuery = true)

    // 원래 jpql 쿼리문 (nativeQuery = true 안하면!!!)
//    @Entity("categoryEntity")
//    @Query(value = "SELECT m FROM categoryEntity m  ORDER BY m.category_cod)


    List<Category> findAllCategory();
}
