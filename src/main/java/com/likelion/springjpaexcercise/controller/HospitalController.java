package com.likelion.springjpaexcercise.controller;


import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import com.likelion.springjpaexcercise.entity.dto.HospitalAddRequestDto;
import com.likelion.springjpaexcercise.entity.dto.HospitalAddResponseDto;
import com.likelion.springjpaexcercise.repository.HospitalRepository;
import com.likelion.springjpaexcercise.repository.ReviewRepository;
import com.likelion.springjpaexcercise.service.HospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewRepository reviewRepository;

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalService hospitalService, ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.hospitalService = hospitalService;
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> reviewList(@PathVariable Long id){

        return ResponseEntity.ok().body(hospitalService.findReview(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<Hospital>> list(Pageable pageable){

        return ResponseEntity.ok().body(hospitalService.hospitalList(pageable));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<HospitalAddResponseDto> addReview(@PathVariable Long id, @RequestBody HospitalAddRequestDto hospitalAddRequestDto){

        HospitalAddResponseDto hospitalAddResponseDto = hospitalService.addReview(hospitalAddRequestDto, id);


        return ResponseEntity.ok().body(hospitalAddResponseDto);

    }


}
