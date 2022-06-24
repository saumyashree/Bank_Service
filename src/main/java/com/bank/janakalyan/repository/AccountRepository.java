package com.bank.janakalyan.repository;

import com.bank.janakalyan.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

}
