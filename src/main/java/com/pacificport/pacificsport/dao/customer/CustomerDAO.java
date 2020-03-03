package com.pacificport.pacificsport.dao.customer;

import com.pacificport.pacificsport.bean.customer.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();

    public Customer save(Customer customer);

    public Customer findOne(int i);

}
