package com.likelion.springjpaexcercise.service;

import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import com.likelion.springjpaexcercise.entity.dto.HospitalResponseDto;
import com.likelion.springjpaexcercise.repository.HospitalRepository;
import com.likelion.springjpaexcercise.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;


    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<HospitalResponseDto> findReview(Long id){
        Optional<Review> reviewList = reviewRepository.findById(id);

        // many인 것을 기준으로 one인 것을 넣어준다
        List<HospitalResponseDto> hospitalResponseDtoList = reviewList.stream()
                .map(review -> {
                    Optional<Hospital> optionalHospital  = hospitalRepository.findById(review.getHospitalId());
                    return HospitalResponseDto.of(optionalHospital.get(), review);
                }).collect(Collectors.toList());

        return hospitalResponseDtoList;
    }

    public List<HospitalResponseDto> hospitalList(@PageableDefault(size=10, sort="id", direction = Sort.Direction.DESC)
    Pageable pageable){
        Page<Review> reviewList = reviewRepository.findAll(pageable);

        // many인 것을 기준으로 one인 것을 넣어준다
        List<HospitalResponseDto> hospitalResponseDtoList = reviewList.stream()
                .map(review -> {
                    Optional<Hospital> optionalHospital  = hospitalRepository.findById(review.getHospitalId());
                    return HospitalResponseDto.of(optionalHospital.get(), review);
                }).collect(Collectors.toList());

        return hospitalResponseDtoList;
    }


}
