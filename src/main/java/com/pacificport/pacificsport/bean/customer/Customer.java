package com.pacificport.pacificsport.bean.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Customer that purchases form Pacific Sports")
@JsonIgnoreProperties(value={"bankAccount"})
public class Customer {
    private Integer id;
    private String name;
    private String address1;
    // You can also use @JsonIgnore on top of the field you want the endpoint to ignore.
    private String bankAccount;
    private String city;
    private String state;
    private String zip;
    @ApiModelProperty(notes="This is not required")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(Integer id, String name, String address1, String bankAccount, String city, String state, String zip, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.bankAccount = bankAccount;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + bankAccount + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}