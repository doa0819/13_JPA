package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Documented;
import java.util.stream.Stream;

public class EntityManagerCRUDTests {


    private EntityManagerCRUD crud;

    // 단위 기능이 끝나기 전  마다 인스턴스 생성
    @BeforeEach
    void initManager(){
        this.crud = new EntityManagerCRUD();
    }

    //  단위 기능이 끝날때 마다 인스턴스 생성
    //  Transaction
    //   transaction.rollback(); -> 하나의 단위 생성이 끝날때 마다 rollback
    // 현재 rollback 으로 update 되고 있지 않는데 -> update 하기 전으로 돌린다.
    @AfterEach
    void  rollback(){

        EntityTransaction transaction = crud.getManagerInstance().getTransaction();
        transaction.rollback();
    }

    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    /* 필기.
    *   테스트 시에 여러 값들을 이용해서 검증을 진행해야 하는 경우에 경우의 수 만큼 테스트 메소드를
    *   작성해야 한다.
    *   @ParameterizedTest 어노테이션을 붙이게 되면 테스트 매소드에 매개변수를 선언할 수 있다.
    *   (일반적인 테스트 메소드는 매개변수 사용 불가)
    *   파라미터로 전달할 값의 목록 만큼 반복적으로 테스트 메소드를 실행하며 준비 된 값 목록을 전달하여
    *   테스트를 실행할 수 있다. --> given  을 대체할 수 있다.(조건을 굳이 줄 필요없이 대신 비교해 준다)
    *   -> 경우의 수 만큼 메소드를 작성해야 하는데 그걸 간소화 하기 위해 미리 던져놓고 알아서 생성해라
    * */
    @ParameterizedTest
    // @CsvSource : 내부의 값 전달 어노테이션
    /* 필기. 여러 개의 테스트 전용 파라미터 전달. 쉼표(,) 로 값을 구분할 수 있다. */
    @CsvSource({"1,1","2,2","3,3"})
    void testFindMethodByMenuCode(int menuCode, int expected){
        /* "1,1" -> 앞에 1 은  menuCode 뒤에 1은 expected 를 가진다 */

        //when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);
        // then
        Assertions.assertEquals(expected, foundMenu.getMenuCode());

    }

    // Stream<Arguments>  어떤 타입이든 받겠다
    private static Stream<Arguments> newMenu(){
        return Stream.of(
          Arguments.of(
                  "신메뉴",
                  20000,
                  4,
                  "Y"
          )
        );
    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    // menuCode 안쓴 이유   @GeneratedValue(strategy = GenerationType.IDENTITY) autoincrement 로 자동 생성 되게 해 놓음
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus){

        //when
        Menu newMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);  // 빨간불 뜨는건 저것들만 가지고 생성해놓은 것들이 없다(Menu class 에서 5개를 받는데 여기는 4개만 받고 있다 일치 하지 않음 그래서 menuCode 지움)
        Long count = crud.saveAndReturnAllCount(newMenu);

        // then
        Assertions.assertEquals(22, count);

    }

    @DisplayName("매뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 변경된 메뉴")

    void testModifyMenuName(int menuCode, String menuName){

        // when
        Menu modifyMenu = crud.modifyMenuName(menuCode, menuName);

        // then
        Assertions.assertEquals(menuName,modifyMenu.getMenuName());

    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testRemoveMenu(int menuCode){
        Long count = crud.removeAndReturnAllCount(menuCode);
        Assertions.assertEquals(20,count);
    }


}
