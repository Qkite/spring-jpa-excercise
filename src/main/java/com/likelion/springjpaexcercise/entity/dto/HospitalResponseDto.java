package com.likelion.springjpaexcercise.entity.dto;

import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponseDto {

    private Long id;
    private String name;
    private String roadNameAddress;
    private String title;
    private String content;
    private String patientName;

    public static HospitalResponseDto of(Hospital hospital, Review review){
        return HospitalResponseDto.builder()
                .id(hospital.getId())
                .name(hospital.getName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .build();
    }

}
