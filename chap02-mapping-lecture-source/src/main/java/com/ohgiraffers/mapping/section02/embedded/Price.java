package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


/* 필기.
*   @Embeddable : embedded 가 될 수 있는 타입을 지정할 때 사용한다.
*   -> 등록일시, 수정일시 하나로 묶어 놓고 embedded 해서 사용
* */
@Embeddable
public class Price {

    // 끌어올 상태 인데
    // @Embeddable : 끌어와진 상태가 되어 있어야지 끌어다가 쓸수 있다.

    @Column(name = "regular_price")
    private int regularPrice;                // 정가

    @Column(name = "discount_rate")
    private double discountRate;            // 할인율

    @Column(name = "sell_price")
    private int sellPrice;                 // 실제 판매 가격

    protected Price() {
    }


    public Price(int regularPrice, double discountRate) {
        validateNagativePrice(regularPrice);
        validateNagativeDiscountRate(discountRate);

        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.sellPrice = calcSellPrice(regularPrice, discountRate);
    }

    private int calcSellPrice(int regularPrice, double discountRate) {

        return (int) (regularPrice - (regularPrice * discountRate));
    }

    private void validateNagativeDiscountRate(double discountRate) {

        if (regularPrice < 0){
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    private void validateNagativePrice(int regularPrice) {

        if (discountRate < 0){
            throw new IllegalArgumentException("할인율은 음수일 수 없습니다.");
        }

    }
}
