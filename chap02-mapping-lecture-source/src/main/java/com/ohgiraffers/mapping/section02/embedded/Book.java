package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @Column(name = "book_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookNo;
    @Column(name = "book_title")
    private String bookTitle;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private  String publisher;
    @Column(name = "published_date")
    private LocalDate publishedDate;

    // regular_price, discount_rate -> class 따로 만들어서 필요할때 마다 꺼내고 싶다(embedded)
//    @Column(name = "regular_price")
//    private int regularPrice;
//    @Column(name = "discount_rate")
//    private double discountRate;


    // 실제로 price class 안에 있는 모든 컬럼들이 들어가 있는거다.
    @Embedded
    private Price price;


    protected Book() {
    }

    public Book(String bookTitle, String author, String publisher, LocalDate publishedDate, Price price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.price = price;
    }
}
