package com.taxes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @OneToOne
    private Customer customer;
    @ToString.Exclude
    @OneToOne
    private Employee employee;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    @Column(nullable = false, length = 100)
    private String description;
    @Enumerated(EnumType.STRING)
    private State status;
    public enum State{NEW, ON_HOLD, CONFIRMED, CANCELED}
}
