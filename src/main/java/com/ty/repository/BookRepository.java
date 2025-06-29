package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.dto.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {
	
	// Find the last inserted book record to assist in generating the next custom book ID
	Book findTopByOrderByIdDesc();	
}

