package com.taxes.repositories;

import com.taxes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findAllByStatus(User.Status status);
    List <User> findByEmailEndingWith(String endLetters);
    List<User> findAllByCreatedBefore(LocalDateTime localDate);
    List<User> findAllByUpdatedAndStatus(LocalDateTime localDate, User.Status status);

}
