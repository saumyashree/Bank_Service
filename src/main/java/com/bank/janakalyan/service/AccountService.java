package com.bank.janakalyan.service;

import com.bank.janakalyan.dto.*;

import java.util.List;

public interface  AccountService {
    AccountDTO credit(Long customerId, Double amount);
    AccountDTO debit(Long customerId, Double balance);
    List<TransactionDTO> getAllTransactions(Long customerId);
    List<CustomerDTO> addBeneficiary(BeneficiaryDTO beneficiaryDTO);
    String transferMoney(TransferDTO transferDTO);
}
