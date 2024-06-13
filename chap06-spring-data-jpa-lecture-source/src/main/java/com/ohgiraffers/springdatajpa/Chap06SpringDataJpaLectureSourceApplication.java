package com.ohgiraffers.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chap06SpringDataJpaLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap06SpringDataJpaLectureSourceApplication.class, args);


        // 원래 패키지 밖에 잇을때는 모든 main 하위에 있는 파일을들 다 읽었지만
        // config 쪽으로 옮긴 후부터는 config 하위에 있는 것들만 읽을수 있게 되었다
        // 그래서 ContextConfiguration 만들어서 전체 하위 폴더 읽게 세팅
    }

}
