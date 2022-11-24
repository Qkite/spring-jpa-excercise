package com.likelion.springjpaexcercise.service;

import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import com.likelion.springjpaexcercise.entity.dto.HospitalAddRequestDto;
import com.likelion.springjpaexcercise.entity.dto.HospitalAddResponseDto;
import com.likelion.springjpaexcercise.repository.HospitalRepository;
import com.likelion.springjpaexcercise.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;


    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findReview(Long id){

        Review review = new Review();

        Hospital findHospital = hospitalRepository.findById(id).get();

        List<Review> reviewList = findHospital.getReview();

        return reviewList;
    }

    public Page<Hospital> hospitalList(@PageableDefault(size=10, sort="id", direction = Sort.Direction.DESC)
    Pageable pageable){
        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);

        return hospitalPage;
    }

    public HospitalAddResponseDto addReview(HospitalAddRequestDto requestDto, Long hospitalId){

        Optional<Hospital> hospitalOptional= hospitalRepository.findById(hospitalId);
        Hospital hospital = hospitalOptional.get();

        HospitalAddResponseDto hospitalAddResponseDto = new HospitalAddResponseDto(requestDto.getTitle(), requestDto.getContent(), requestDto.getPatientName(), hospitalId);

        Review review = hospitalAddResponseDto.toEntity(hospital, requestDto);
        reviewRepository.save(review);


        return hospitalAddResponseDto;
    }



}
