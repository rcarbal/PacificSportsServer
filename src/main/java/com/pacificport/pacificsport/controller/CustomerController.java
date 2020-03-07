package com.pacificport.pacificsport.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.pacificport.pacificsport.bean.customer.Customer;
import com.pacificport.pacificsport.exception.UserNotFoundException;
import com.pacificport.pacificsport.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public MappingJacksonValue retrieveAllCustomers(){

        List<Customer> customers = service.findAll();

        // Add dynamic filtering to this call to ignore the Customers bank account number
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "state", "phoneNumber");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("CustomerBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(customers);
        mapping.setFilters(filterProvider);

        return mapping;
    }

    @GetMapping("/customers/{id}")
    public MappingJacksonValue retrieveCustomer(@PathVariable int id){

        Customer customer = service.findOne(id);
        if (customer == null){
            throw new UserNotFoundException("id-" + id);
        }

        // returns a link to all the users in the database
        Resource<Customer> resource = new Resource<>(customer);
        ControllerLinkBuilder theLink = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        resource.add(theLink.withRel("the-customers"));

        // Add dynamic filtering to this call to ignore the Customers bank account number
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "state", "phoneNumber",
                "bankAccount", "zip");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("CustomerBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(customer);
        mapping.setFilters(filterProvider);


        return mapping;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id){

        Customer customer = service.deleteById(id);
        if (customer == null){
            throw new UserNotFoundException("id-" + id);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
        Customer cust = service.save(customer);

        // take the current path and append the id to create a uri
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                // append to the current path
                .path("/{id}")
                // the value of what will get appended
                .buildAndExpand(cust.getId())
                .toUri();

        // returns a status code of created
        // pass in the location uri into created()
        return ResponseEntity.created(location).build();
    }
}