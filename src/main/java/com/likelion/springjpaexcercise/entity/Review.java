package com.likelion.springjpaexcercise.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    @JsonManagedReference
    private Hospital hospital;


    public Review(String title, String content, String patientName, Hospital hospital){
        this.title = title;
        this.content = content;
        this.patientName = patientName;
        this.hospital = hospital;

    }



}
