package com.taxes.repositories;

import com.taxes.domain.Customer;
import com.taxes.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByCreated(LocalDateTime localDateTime);
    List<Customer> findByUpdatedAfter(LocalDateTime localDateTime);
    List<Customer> findCustomerByStatus(Customer.Status status);


}
