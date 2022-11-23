package com.likelion.springjpaexcercise.controller;


import com.likelion.springjpaexcercise.entity.dto.BookResponseDto;
import com.likelion.springjpaexcercise.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookResponseDto>> list(Pageable pageable){

        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }

}
