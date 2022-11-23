package com.likelion.springjpaexcercise.repository;

import com.likelion.springjpaexcercise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
