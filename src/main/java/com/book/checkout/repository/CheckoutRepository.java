package com.book.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.checkout.entity.PromoCode;

@Repository
public interface CheckoutRepository extends JpaRepository<PromoCode, Long>{

}
