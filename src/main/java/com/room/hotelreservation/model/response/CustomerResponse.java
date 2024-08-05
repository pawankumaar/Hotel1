package com.room.hotelreservation.model.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long customerId;
    private String name;
    private String idProof;
    private Long mobileNumber;
}
