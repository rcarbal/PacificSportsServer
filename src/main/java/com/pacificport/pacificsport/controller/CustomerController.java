package com.pacificport.pacificsport.controller;

import com.pacificport.pacificsport.bean.customer.Customer;
import com.pacificport.pacificsport.exception.UserNotFoundException;
import com.pacificport.pacificsport.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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
    public EntityModel<Customer> retrieveCustomer(@PathVariable int id){

        Customer customer = service.findOne(id);
        if (customer == null){
            throw new UserNotFoundException("id-" + id);
        }

        // returns a link to all the users in the database
        EntityModel<Customer> resource = new EntityModel<>(customer);
        WebMvcLinkBuilder theLink = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
        resource.add(theLink.withRel("the-customers"));


        return resource;
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