package com.room.hotelreservation.model.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRegistrationRequest {

    @Size(min = 10, max = 16, message = "Name should be between 10 and 16")
    private String name;
    @Size(min = 16, max = 16, message = "ID Proof should be of 16 characters")
    private String idProof;
    @Size(min = 10, max = 10, message = "Mobile Number should be of 10 digits")
    private Long mobileNumber;

}
