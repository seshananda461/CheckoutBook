package com.book.checkout.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.checkout.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	/**
	 * 
	 * @param bookId
	 * @param pageable
	 * @return
	 */
	Page<Book> findByBookId(Long bookId, Pageable pageable);

	

}