package com.taxes.repositories;

import com.taxes.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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












//    @Query(value = "SELECT * FROM person WHERE firstName = :firstName AND lastName = :lastName", nativeQuery = true)
//    Person findPersonBySecondNameAndFirstName(@Param("firstName") String firstName, @Param("secondName") String secondName);

