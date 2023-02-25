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
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @ToString.Exclude
    private Customer customer;
    @OneToOne
    @ToString.Exclude
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private Period period;
    @Column(nullable = false)

    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    public enum Period{MONTH, QUARTER, YEAR}
}
