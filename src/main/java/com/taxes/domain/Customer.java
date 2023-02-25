package com.taxes.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    private Person person;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status; // find by status
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    @OneToMany
    @ToString.Exclude
    private List<Report>reports;
    @OneToMany
    @ToString.Exclude
    private Set<Request> requests;
    public enum Status {INDIVIDUAL, COMPANY}
}
