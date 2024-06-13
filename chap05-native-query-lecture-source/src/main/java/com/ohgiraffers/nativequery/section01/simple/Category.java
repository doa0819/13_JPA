package com.ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.*;

@Entity(name = "section01Category")
@Table(name = "tbl_category")
@SqlResultSetMappings(value = {
        /* 1. @Colum 으로 매핑 설정이 되어 있는 경우(자동)*/
        @SqlResultSetMapping(
                name = "categoryAutoMapping",
                entities = {@EntityResult(entityClass = Category.class)},
                columns = {@ColumnResult(name="menu_count")}
        ),
        /* 2. 매핑 설정을 수동으로 하는 경우(@Column 어노테이션 생략 가능) */
        @SqlResultSetMapping(
                name = "categoryManualMapping",
                entities = {
                        @EntityResult(entityClass = Category.class, fields = {
                                @FieldResult(name = "categoryCode", column = "category_code"),
                                @FieldResult(name = "categoryName", column = "category_name"),
                                @FieldResult(name = "refCategoryCode", column = "ref_category_code")
                        })
                },
                columns = {@ColumnResult(name = "menu_count")}
        )

})
// COALESCE : 여러 개의 인자를 받고 첫 번째로 NULL이 아닌 값을 반환
// COALESCE(v.menu_count, 0) menu_count ->  menu_count 가 null 이면 0으로 반환

@NamedNativeQuery(
        name = "namedNativeQueryMapping",
        query = "SELECT a.category_code, a.category_name, a.ref_category_code, COALESCE(v.menu_count, 0) menu_count" +
                " FROM tbl_category a" +
                " LEFT JOIN(SELECT COUNT(*) AS menu_count, b.category_code" +
                " FROM tbl_menu b" +
                " GROUP BY b.category_code) v ON (a.category_code = v.category_code)" +
                " ORDER BY 1",
        resultSetMapping = "categoryManualMapping"
)
public class Category {


    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    // Integer -> null값 포함 가능
    // int -> 기본자료형이여서 null 값 포함 XX
    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
