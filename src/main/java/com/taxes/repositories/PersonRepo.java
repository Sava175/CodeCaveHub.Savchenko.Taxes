package com.taxes.repositories;

import com.taxes.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByLastNameAndFirstName(String firstName, String lastName);
    Person findByPhone(String phone);
    List<Person> findAllByCategory(Person.Category category);
    List<Person> findAllByDobGreaterThan(LocalDate dob);
    List<Person> findAllByCreated(LocalDateTime localDateTime);
    List<Person> findAllByPhoneStartingWith(String mark);
    List<Person> findAllByAddressContaining(String clarification);


}


