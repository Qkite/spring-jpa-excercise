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
public class Hospital {

    @Id
    private Long id;

    @Column(name = "hospital_name")
    private String name;

    private String roadNameAddress;


}
