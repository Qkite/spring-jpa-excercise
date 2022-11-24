package com.likelion.springjpaexcercise.entity.dto;

import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalAddRequestDto {

    private String title;
    private String content;
    private String patientName;


}
