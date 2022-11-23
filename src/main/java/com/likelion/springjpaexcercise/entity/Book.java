package com.likelion.springjpaexcercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author_id")
    private Long authorId;
}
