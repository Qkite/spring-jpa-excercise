package com.likelion.springjpaexcercise.controller;


import com.likelion.springjpaexcercise.entity.dto.BookDto;
import com.likelion.springjpaexcercise.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {



    @GetMapping("/list/{id}")
    public String bookList(Long id){

        BookDto bookDto = new BookDto();
        bookDto.



    }

}
