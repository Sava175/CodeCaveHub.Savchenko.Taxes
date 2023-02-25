package com.taxes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(length = 170)
    private String address;
    @Column(nullable = false, unique = true, length = 25)
    private String phone;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    @Column(updatable = false)
    private char sex;
    @Column(nullable = false, updatable = false)
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Category category;
    public enum Category {CITIZEN, FOREIGNER, GOVERNMENT_WORKER}


}
