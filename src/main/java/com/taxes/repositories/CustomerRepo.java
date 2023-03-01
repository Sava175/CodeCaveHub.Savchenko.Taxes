package com.taxes.repositories;

import com.taxes.domain.Customer;
import com.taxes.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByCreated(LocalDateTime localDateTime);
    List<Customer> findByUpdatedAfter(LocalDateTime localDateTime);
    List<Customer> findCustomerByStatus(Customer.Status status);
    default List<Report> findAllLastReportsOfCustomer(){
        List<Report> reports = new ArrayList<>();
        List<Customer> customers = this.findAll();
        for(Customer customer: customers){
            if (customer.getReports().isEmpty()){
                continue;
            }
            customer.getReports().sort((r1, r2) -> r2.getCreated().compareTo(r1.getCreated()));
            reports.add(customer.getReports().get(0));
        }
        return reports;
    }



}
