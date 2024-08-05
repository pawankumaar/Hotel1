package com.room.hotelreservation.controller;

import com.room.hotelreservation.model.request.CustomerRegistrationRequest;
import com.room.hotelreservation.model.response.CustomerResponse;
import com.room.hotelreservation.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is to maintain the RestController API Endpoints
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return new ResponseEntity(customerService.saveCustomer(customerRegistrationRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerResponse> getCustomer(@RequestParam("customerId") Long cusomterId){
        return customerService.getCustomerById(cusomterId);
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("customer-id") Long customerId,
                                                           @RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return customerService.updateCustomer(customerId,customerRegistrationRequest);

    }

}
