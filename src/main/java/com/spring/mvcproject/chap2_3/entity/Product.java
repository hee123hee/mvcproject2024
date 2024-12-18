package com.spring.mvcproject.chap2_3.entity;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id; // 상품 아이디
    private String name; // 상품명
    private int price; // 상품 가격
}
