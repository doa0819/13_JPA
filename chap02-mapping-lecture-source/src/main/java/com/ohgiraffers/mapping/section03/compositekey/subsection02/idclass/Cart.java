package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
@IdClass(CartCompositeKey.class)
public class Cart {

    @Id
    @Column(name = "cart_owner")
    private int cartOwner;


    @Id
    @Column(name = "added_book")
    private int addedBook;

    /**/

    @Column(name = "quantity")
    private int quantity;

    public Cart() {
    }

    public Cart(int cartOwner, int addedBook, int quantity) {
        this.cartOwner = cartOwner;
        this.addedBook = addedBook;
        this.quantity = quantity;
    }

    /*  @Entity = 데이터 베이스 => 직접적으로 값 세팅 하는거 아님
        그래서 setter XX (마음대로 값 쓰지 않게 setter 지향)/ getter 만 사용 => DTO 에서 값을 꺼내와서 사용
    * */

    public int getCartOwner() {
        return cartOwner;
    }

    public int getAddedBook() {
        return addedBook;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartOwner=" + cartOwner +
                ", addedBook=" + addedBook +
                ", quantity=" + quantity +
                '}';
    }
}
