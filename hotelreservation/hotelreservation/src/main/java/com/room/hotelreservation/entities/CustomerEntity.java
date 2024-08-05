package com.room.hotelreservation.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    private String name;

    @Column(name = "id_proof")
    private String idProof;

    @Column(name = "mobile_number")
    private Long mobileNumber;


}
