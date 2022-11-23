package com.likelion.springjpaexcercise.controller;


import com.likelion.springjpaexcercise.entity.Hospital;
import com.likelion.springjpaexcercise.entity.Review;
import com.likelion.springjpaexcercise.entity.dto.HospitalResponseDto;
import com.likelion.springjpaexcercise.service.HospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> reviewList(@PathVariable Long id){

        return ResponseEntity.ok().body(hospitalService.findReview(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<Hospital>> list(Pageable pageable){

        return ResponseEntity.ok().body(hospitalService.hospitalList(pageable));
    }


}
