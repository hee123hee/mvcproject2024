package com.spring.mvcproject.chap2_4.controller;

import com.spring.mvcproject.chap2_4.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    // 데이터베이스 대용으로 책들을 모아서 관리
    private Map<Long, Book> bookStore = new HashMap<>();

    private Long nextId = 1L;

    public BookController() {
        bookStore.put(nextId, new Book(nextId, "클린코드", "로버트 마틴", 20000));
        nextId++;
        bookStore.put(nextId, new Book(nextId, "해리포터", "조앤 롤링", 10000));
        nextId++;
        bookStore.put(nextId, new Book(nextId, "삼국지", "나관중", 15000));
        nextId++;
    }

    // 1. 목록 조회
    @GetMapping
    public List<Book> list() {
        return new ArrayList<>(bookStore.values());
    }
    // 2. 개별 조회
    @GetMapping("/{id}")
    public Object getBook(@PathVariable Long id) {
        Book foundBook = bookStore.get(id);

        if (foundBook == null) {
            return "해당 도서는 존재하지 않습니다: id - " + id;
        }
        return foundBook;
    }

    // 3. 도서 생성
    @PostMapping
    public String createBook(
            String title, String author, int price
    ) {
        // 새 도서 객체 생성
        Book newBook = new Book(nextId++, title, author, price);
        // 맵에 저장
        bookStore.put(newBook.getId(), newBook);

        return "도서 추가 완료: " + newBook.getId();
    }

    // 4. 도서 수정
    @PutMapping("/{id}")
    public String updateBook(
            @PathVariable Long id,
            String title, String author, int price
    ) {
        // 기존 도서 객체를 조회
        Book foundBook = bookStore.get(id);

        if (foundBook == null) {
            return id + "번 도서는 존재하지 않습니다. 수정 실패!";
        }

        // 새 데이터로 수정
        foundBook.updateBook(title, author, price);

        return "도서 수정 완료: " + foundBook.getId();
    }

    // 5. 도서 삭제
    @DeleteMapping("/{id}")
    public String deleteBook(
            @PathVariable Long id
    ) {
        // 맵에서 데이터를 제거
        Book removed = bookStore.remove(id);

        if (removed == null) {
            return id + "번 도서는 존재하지 않습니다. 삭제 실패!";
        }

        return "도서 삭제 완료: " + id;
    }

    // 6. 현재 도서가 몇권 있는지 알려주세요 요청
    @GetMapping("/count")
    public String count() {
        return "현재 저장된 도서의 개수: " + bookStore.size() + "권";
    }

}
