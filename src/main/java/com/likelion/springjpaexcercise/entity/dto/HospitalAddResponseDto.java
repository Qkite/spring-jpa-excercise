package com.likelion.springjpaexcercise.entity.dto;

import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import com.likelion.springjpaexcercise.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalAddResponseDto {

    private String title;
    private String content;
    private String patientName;
    private Long hospitalId;


    public Review toEntity(Hospital hospital, HospitalAddRequestDto hospitalAddRequestDto){


        return new Review(hospitalAddRequestDto.getTitle(), hospitalAddRequestDto.getContent(), hospitalAddRequestDto.getPatientName(), hospital);
    }

}
