package com.likelion.springjpaexcercise.service;

import com.likelion.springjpaexcercise.entity.Author;
import com.likelion.springjpaexcercise.entity.Book;
import com.likelion.springjpaexcercise.entity.dto.BookResponseDto;
import com.likelion.springjpaexcercise.repository.AuthorRepository;
import com.likelion.springjpaexcercise.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponseDto> findBooks(Pageable pageable){

        Page<Book> bookPage = bookRepository.findAll(pageable);
        List<BookResponseDto> bookResponseDtos = bookPage.stream()
                .map(book -> {
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
                    return BookResponseDto.of(book, optionalAuthor.get().getName());
                }).collect(Collectors.toList());

        return bookResponseDtos;
    }
}
