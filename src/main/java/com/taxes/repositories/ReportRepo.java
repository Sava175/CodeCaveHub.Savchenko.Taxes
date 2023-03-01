package com.taxes.repositories;

import com.taxes.domain.Employee;
import com.taxes.domain.Person;
import com.taxes.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReportRepo extends JpaRepository<Report, Long> {

    List<Report> findAllByCreated(LocalDateTime created);
    List<Report> findAllByUpdated(LocalDateTime updated);
    List<Report> findAllByCreatedGreaterThan(LocalDateTime localDateTime);
    List<Report> findAllByCreatedBetween(LocalDateTime after, LocalDateTime before);
    List<Report> findAllByCreatedBetweenAndCustomer_Id(LocalDateTime from, LocalDateTime to, Long id);
    List<Report> findAllByCreatedBetweenAndUpdatedBefore(LocalDateTime from, LocalDateTime to, LocalDateTime up);
    List<Report> findReportsByEmployee_Person_LastNameStartsWith(String letter);






}
