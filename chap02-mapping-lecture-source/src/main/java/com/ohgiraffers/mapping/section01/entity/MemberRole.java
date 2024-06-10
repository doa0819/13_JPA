package com.ohgiraffers.mapping.section01.entity;

// enum : Enumerated(즁요!!) type
public enum MemberRole {

    // enum 값들은 다 final 바뀔수 없는 값들이다.
    /* 필기.
    *   Enum 타입을 사용하게 된다면 코드의 가독성 향상
    *   type safety(타입의 안정성)을 보장할 수 있다.
    *   서로 연관 된 상수들의 집합 클래스이다.
    * */
    /* 필기.
        ORDINAL 의 특징 -> 데이터베이스에 차지하는 공간이 적어진다.
    *   필드가 작성된 순서대로 번호가 매겨진다.
    *   ROLE_MEMBER, -> 1번
        ROLE_ADMIN   -> 2번
    * */
    ROLE_MEMBER,
    ROLE_ADMIN
}
