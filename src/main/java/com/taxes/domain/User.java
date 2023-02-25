package com.taxes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(length = 30)
    private String password;
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    public enum Status {NEW, ACTIVE, BLOCKED, BANNED}
}
