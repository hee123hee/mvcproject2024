package com.spring.mvcproject.chap2_4.entity;

import lombok.*;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id; // 책을 유일하게 구분하는 필드
    private String title;
    private String author;
    private int price;

    // 수정 편의 메서드
    public void updateBook(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
