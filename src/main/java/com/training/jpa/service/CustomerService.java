package com.training.jpa.service;


import com.training.jpa.entity.Customer;
import com.training.jpa.model.dto.CustomerDTO;
import com.training.jpa.model.request.CustomerRequest;
import com.training.jpa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO createCustomer(CustomerRequest request) {
        Customer customerCreated = customerRepository.save(Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .build());
        return new CustomerDTO(customerCreated);
    }

    @Transactional
    public CustomerDTO updateCustomer(Integer customerId, CustomerRequest request){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found!"));
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setPhone(request.phone());
        customer.setAddress(request.address());
        return new CustomerDTO(customerRepository.save(customer));
    }


    @Transactional
    public void deleteCustomer(Integer customerId){
        customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found!"));
        customerRepository.deleteById(customerId);
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> listCustomer(){
        return customerRepository.findAll().stream().map(CustomerDTO::new).toList();
    }

    @Transactional
    public CustomerDTO getCustomer(Integer customerId){
        return customerRepository.findById(customerId).map(CustomerDTO::new).orElseThrow(() -> new RuntimeException("Customer not found!")  );
    }

}
