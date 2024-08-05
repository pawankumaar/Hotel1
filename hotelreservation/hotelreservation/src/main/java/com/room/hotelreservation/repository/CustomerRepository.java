package com.room.hotelreservation.repository;

import com.room.hotelreservation.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByCustomerId(Long customerId);
    Optional<CustomerEntity> findByCustomerIdAndName(Long customererId, String name);
    List<CustomerEntity> findAllByCustomerId(Long customerId);
}
