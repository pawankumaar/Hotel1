package com.room.hotelreservation.controller;

import com.room.hotelreservation.model.request.CustomerRegistrationRequest;
import com.room.hotelreservation.model.response.CustomerResponse;
import com.room.hotelreservation.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("customer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return new ResponseEntity(customerService.saveCustomer(customerRegistrationRequest), HttpStatus.CREATED);
    }

    @GetMapping("customer")
    public ResponseEntity<CustomerResponse> getCustomer(@RequestParam("customerId") Long cusomterId){
        return customerService.getCustomerById(cusomterId);
    }

}
