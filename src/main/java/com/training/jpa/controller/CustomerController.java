package com.training.jpa.controller;


import com.training.jpa.model.dto.CustomerDTO;
import com.training.jpa.model.request.CustomerRequest;
import com.training.jpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    // POST: /customers
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO create(@RequestBody CustomerRequest request){
        return customerService.createCustomer(request);
    }

    // PUT: /customers/1
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO update(@PathVariable("id") Integer customerId, @RequestBody CustomerRequest request){
        return customerService.updateCustomer(customerId, request);
    }
    // GET: /customers/1 ( Search by id )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO get(@PathVariable("id") Integer customerId){
        return customerService.getCustomer(customerId);
    }

    // DELETE: /customers/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer customerId){
        customerService.deleteCustomer(customerId);
    }

    // GET: /customers
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> list(){
        return customerService.listCustomer();
    }


}
