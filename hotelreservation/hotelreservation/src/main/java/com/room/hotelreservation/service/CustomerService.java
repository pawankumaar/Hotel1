package com.room.hotelreservation.service;

import com.room.hotelreservation.entities.CustomerEntity;
import com.room.hotelreservation.model.request.CustomerRegistrationRequest;
import com.room.hotelreservation.model.response.CustomerResponse;
import com.room.hotelreservation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse saveCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerRegistrationRequest.getName());
        customerEntity.setIdProof(customerRegistrationRequest.getIdProof());
        customerEntity.setMobileNumber(customerRegistrationRequest.getMobileNumber());
        customerEntity = customerRepository.save(customerEntity);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customerEntity.getCustomerId());
        customerResponse.setName(customerEntity.getName());
        customerResponse.setIdProof(customerEntity.getIdProof());
        customerResponse.setMobileNumber(customerEntity.getMobileNumber());

        return customerResponse;
    }

    public ResponseEntity<CustomerResponse> getCustomerById(Long customerId){
        Optional<CustomerEntity>  customerEntityOptional = customerRepository.findByCustomerId(customerId);
        if(customerEntityOptional.isPresent()){
            CustomerEntity customerEntity = customerEntityOptional.get();
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setCustomerId(customerEntity.getCustomerId());
            customerResponse.setName(customerEntity.getName());
            customerResponse.setIdProof(customerEntity.getIdProof());
            customerResponse.setMobileNumber(customerEntity.getMobileNumber());
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
        }
    }
}
