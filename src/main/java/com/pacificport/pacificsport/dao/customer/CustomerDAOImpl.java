package com.pacificport.pacificsport.dao.customer;

import com.pacificport.pacificsport.bean.customer.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO{

    private static List<Customer> customers = new ArrayList<>();
    private static int userCount = 3;

    static {
        customers.add(new Customer(
                1,
                "Test Customer",
                "15847 Maryland st",
                "None","Calabasus",
                "CA",
                "90002",
                "686-587-8888"));
        customers.add(new Customer(
                2,
                "Ricardo Customer",
                "847 Lander st",
                "None","Los Angeles",
                "CA",
                "90002",
                "784-111-847"));
        customers.add(new Customer(
                3,
                "Lianny Customer",
                "584 Cruise st",
                "None","La Puente",
                "CA",
                "97445",
                "854-781-1588"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null){
            customer.setId(++userCount);
        }
       customers.add(customer);
        return customer;
    }

    @Override
    public Customer findOne(int id) {
        for (Customer customer: customers){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
}
