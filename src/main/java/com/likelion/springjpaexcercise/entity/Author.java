package com.likelion.springjpaexcercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String name;
}
