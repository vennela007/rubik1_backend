package com.ing.rubikbankdetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.rubikbankdetails.entity.BankDetails;

@Repository
public interface BankRepository extends JpaRepository<BankDetails, Integer> {
	Optional<BankDetails> findByBankCode(String code);

}
