package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.bean.customer.Customer;
import com.pacificport.pacificsport.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers(){
        return service.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer retrieveCustomer(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer){
        Customer cust = service.save(customer);
    }



}
