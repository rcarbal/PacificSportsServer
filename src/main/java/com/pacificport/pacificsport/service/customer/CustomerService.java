package com.pacificport.pacificsport.service.customer;

import com.pacificport.pacificsport.bean.customer.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findOne(int id);

    public Customer save(Customer customer);

    public Customer deleteById(int id);
}
