package com.likelion.springjpaexcercise.repository;

import com.likelion.springjpaexcercise.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Optional<Review> findByHospitalId(Long id);
}
