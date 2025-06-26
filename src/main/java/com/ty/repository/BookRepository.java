package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.dto.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {
	 // To find the latest book based on ID (used for custom bookId generation if needed)
    Book findTopByOrderByIdDesc();	
}

