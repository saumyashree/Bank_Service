package com.bank.janakalyan.repository;

import com.bank.janakalyan.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
    Optional<List<TransactionEntity>> findByCustomerId(Long customerId);

}
