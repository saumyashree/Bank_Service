package com.bank.janakalyan.controller;


import com.bank.janakalyan.dto.*;
import com.bank.janakalyan.service.AccountService;
import com.bank.janakalyan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> register(@Valid @RequestBody CustomerDTO customerDTO){
        customerDTO = customerService.register(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomerDTO customerDTO) {
        String msg = (customerService.login(customerDTO.getOwnerEmail(),customerDTO.getPassword()));
        ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/credit/{customerId}")
    public ResponseEntity<AccountDTO>credit(@PathVariable Long customerId, @RequestBody AccountDTO accountDTO){
        AccountDTO account=accountService.credit(customerId,accountDTO.getBalance());
        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(account, HttpStatus.OK);
        return responseEntity;
    }
    @PostMapping("/debit/{customerId}")
    public ResponseEntity<AccountDTO> debit(@PathVariable Long customerId, @RequestBody AccountDTO accountDTO){
        AccountDTO account=accountService.debit(customerId,accountDTO.getBalance());
        ResponseEntity<AccountDTO> responseEntity = new ResponseEntity<>(account, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/alltransactions/{customerId}")
    public ResponseEntity<List<TransactionDTO>> getAllTransactionss(@PathVariable Long customerId){
        List<TransactionDTO> transList=accountService.getAllTransactions(customerId);
        ResponseEntity<List<TransactionDTO>> responseEntity = new ResponseEntity<>(transList, HttpStatus.OK);
        return responseEntity;
    }

@PostMapping("/addBeneficiary")
    public ResponseEntity<List<CustomerDTO>> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO){
    List<CustomerDTO> beneficiaryList=accountService.addBeneficiary(beneficiaryDTO);
    ResponseEntity<List<CustomerDTO>> responseEntity = new ResponseEntity<>(beneficiaryList, HttpStatus.OK);
    return responseEntity;
}
@PostMapping("/transfer_money")
  public ResponseEntity<String> transferMoney(@RequestBody TransferDTO transferDTO){
    String msg=accountService.transferMoney(transferDTO);
    ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
    return responseEntity;

}}
