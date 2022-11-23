package com.likelion.springjpaexcercise.repository;

import com.likelion.springjpaexcercise.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
