package com.likelion.springjpaexcercise.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Review> review;



}
