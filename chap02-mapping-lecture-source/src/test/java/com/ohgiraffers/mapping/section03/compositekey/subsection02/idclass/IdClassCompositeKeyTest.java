package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class IdClassCompositeKeyTest {

    @Autowired
    private CartRegistService cartRegistService;

    // 복합키 : pk 가 2 개 이므로 한행으로 두개 실행 가능
    private static Stream<Arguments>getCartInfo(){
        return Stream.of(
                Arguments.of(1,2,10),
                Arguments.of(1,3,5),
                Arguments.of(2,1,1),
                Arguments.of(2,2,20)
        );
    }

    @ParameterizedTest(name = "{0} 번 회원이 {1} 번 책을 카트에 {2} 권 담기 테스트")
    @MethodSource("getCartInfo")
    void testAddItemToCart(int cartOwnerMemberNo, int addedBookNo, int quantity){

        Assertions.assertDoesNotThrow(
                () -> cartRegistService.addItemToCart(

                        // addItemToCart 에 저 위에 세개를 같이 넘겨 주고 싶어서 DTO 를 만들엇서 넣어준다.
                        new CartDTO(cartOwnerMemberNo, addedBookNo, quantity )
                )
        );
    }

}
