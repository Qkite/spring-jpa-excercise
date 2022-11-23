package com.likelion.springjpaexcercise.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private Long id;
    private String title;
    private String content;
    private String patientName;
    private Long hospitalId;



}
