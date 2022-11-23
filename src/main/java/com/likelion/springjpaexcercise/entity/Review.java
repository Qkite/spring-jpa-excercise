package com.likelion.springjpaexcercise.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private Long id;
    private Long hospitalId;
    private String title;
    private String contentName;



}
