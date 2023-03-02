package com.taxes.domain;

import lombok.*;

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

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
