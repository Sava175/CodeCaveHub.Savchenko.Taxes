package com.taxes.domain;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    private Person person;

    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Position position;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Report>reports = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Request> requests = new HashSet<>();


    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    public enum Position{MANAGER, DIRECTOR}
}
