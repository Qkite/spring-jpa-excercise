package com.likelion.springjpaexcercise.entity.dto;

import com.likelion.springjpaexcercise.entity.Book;
import com.likelion.springjpaexcercise.repository.AuthorRepository;
import com.likelion.springjpaexcercise.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {


    private Long id;
    private String name;
    private String authorName;

    public static BookResponseDto of(Book book, String authorName) {

        return BookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(authorName)
                .build();
    }

}
