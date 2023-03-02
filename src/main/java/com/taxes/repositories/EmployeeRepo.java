package com.taxes.repositories;

import com.taxes.domain.Customer;
import com.taxes.domain.Employee;
import com.taxes.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findAllByCreated(LocalDateTime localDateTime);
    List<Employee> findByUpdated(LocalDateTime localDateTime);
    List<Employee> findEmployeeByPositionAndCreated(Employee.Position position, LocalDateTime created);




}

