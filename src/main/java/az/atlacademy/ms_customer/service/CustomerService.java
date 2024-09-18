package az.atlacademy.ms_customer.service;


import az.atlacademy.ms_customer.model.response.CustomerResponseDto;
import az.atlacademy.ms_customer.model.request.SaveCustomerDto;
import az.atlacademy.ms_customer.model.response.CustomerResponseDto;

import java.math.BigDecimal;

public interface CustomerService {
    void saveCustomer(SaveCustomerDto dto);

   CustomerResponseDto getCustomerById(Long id);

    void reduceBalance(Long id, BigDecimal totalAmount);
}

