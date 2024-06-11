package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;

@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    /* 연속성 전이 : 예) 코드를 123 으로 넣을건데
    *   특정 엔티티를 영속화(등록) 할 때, 연관 된 엔티티도 함께
    *   영속화 한다는 의미다.
    *   즉
    *   -> Menu 엔티티를 영속화 할 때, Category 엔티티도 같이 영속화 시키낟.
    *   카테고리를 이용해서 만들건데 카테고리 테이블이 없는데 메뉴 테이블을 만들수 없기 때문에
    *   insert 시 카테고리 테이블 먼저 만들고 menu 테이블을 만든다.
    * */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_code")  // Fk 랑 비슷하다(category_code 기반으로 가지고 올 것이다.)
    private Category category;

    @Column(name = "orderable_status")
    private String orderableStatus;

    protected Menu(){}

    public Menu(int manuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = manuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "manuCode=" + menuCode +
                ", menuName=" + menuName +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
