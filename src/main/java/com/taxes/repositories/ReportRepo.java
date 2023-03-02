package com.taxes.repositories;

import com.taxes.domain.Employee;
import com.taxes.domain.Person;
import com.taxes.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;


public interface ReportRepo extends JpaRepository<Report, Long> {

    List<Report> findAllByCreated(LocalDateTime created);
    List<Report> findAllByUpdated(LocalDateTime updated);
    List<Report> findAllByCreatedGreaterThan(LocalDateTime localDateTime);
    List<Report> findAllByCreatedBetween(LocalDateTime after, LocalDateTime before);
    List<Report> findAllByCreatedBetweenAndCustomer_Id(LocalDateTime from, LocalDateTime to, Long id);
    List<Report> findAllByCreatedBetweenAndUpdatedBefore(LocalDateTime from, LocalDateTime to, LocalDateTime up);//1
    List<Report> findReportsByEmployee_Person_LastNameStartsWith(String letter); //2
    List<Report> findAllByPeriodAndUpdatedBefore(Report.Period period, LocalDateTime localDateTime);

    List <Report> findAllByPeriodOrderByUpdatedDesc(Report.Period period);//6
    List<Report> findAllByUpdatedAfterAndCustomer_User_EmailContaining(LocalDateTime updated, String email);//5

    List<Report> findAllByCreatedAndUpdatedOrderByCustomer_Person_LastNameAsc(LocalDateTime first, LocalDateTime second);//10
    List<Report> findAllByCreatedBetweenOrderByUpdatedDesc(LocalDateTime first, LocalDateTime second); //7













}
