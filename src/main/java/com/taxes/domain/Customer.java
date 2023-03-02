package com.taxes.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Report>reports = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Request> requests = new HashSet<>();



    public enum Status {INDIVIDUAL, COMPANY}
}
