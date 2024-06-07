package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/*  필기.
*    클래스 선언부 위에 위치해서 JPA에서 사용되는 엔티티 클래스임을 표시한다.
*    이는 해당 클래스와 데이터베이스의 테이블 매핑을 의미한다.
*    @Entity(name ) : 이름정해주는 이유는 같은 이름을 사용할 수 있기 때문에 정해준다.
*    - 기본생성자는 필수로 작성해야 한다.
*    - final 클래스, enum, interface, inner class 에서는 사용할 수 없다.
*    - 저장할 필드에 final 을 사용하면 안된다.
* */
@Entity(name = "entityMember")
@Table(name = "tbl_member", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"member_id", "phone"})
} )
public class Member {

    /* 필기.
    *   @Column 속성
    *   - name : 매핑할 테이블의 컬럼 이름
    *   - nullable : null 값 허용여부 설정 = not null 제약 조건에 해당한다.
    *               -> 기본값 : default(true)
    *   - @GeneratedValue : autoincreament 설정
    *   - unique : 컬럼의 유일성 제약 조건, 두 개 이상의 컬럼에 unique 제약 조건을 설정하기 위해서는
    *               @Table 어노테이션 속성에 uniqueConstrains(유니콘의 제약조건) 속성을 추가해야 한다.
    *   - columnDefinition : 직접 컬럼의 DDL(int, varchar ....) 을 지정할 수 있다.
    *   - length : 문자열의 길이 = String 타입에서만 사용 (default : 255 )
    *   - enum: 딱 정해진 값, 성별, 권한 (여러가지 값 한번에 묶을때 사용)
    *
    */



    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;       // column 를 안쓰면 자동으로 member_no 로 들어간다.

    @Column(name = "member_id", nullable = false, unique = true, columnDefinition = "varchar(10)")   // notnull 제약 조건 넣음
    private String memberId;

    @Column(name = "member_pwd", nullable = false)
    private String memberPwd;

    @Column(name = "member_name")
    private  String memberName;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "address", length = 900)
    private String address;

    @Column(name = "enroll_date")
    private LocalDateTime enrollDate;

    /* 필기.
    *   @Enumerated
    *   - enum 타입을 매핑하기 위해서 사용한다.
    *   - ORDINAL : Enum 타입을 순서로 매핑
    *          // 장점 : 데이터베이스에 저장되는 데이터의 크기가 작음
    *             단점 : 알아보기 어렵다.
    *   - STRING  : Enum 타입을 문자열로 매핑
    * */
    @Column(name = "member_role")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    // status : 맴버 활성 여부 ("Y/N" 으로 관리)
    @Column(name = "status", columnDefinition = "char(1) default 'Y'")
    private String status;

    //     protected : 기본생성자의 접근 범위를 줄여준다.
    protected Member(){}

    public Member(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, MemberRole memberRole, String status) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
}


