package com.bank.janakalyan.service;

import com.bank.janakalyan.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO register(CustomerDTO customerDTO);
    String login(String email, String password);

}
