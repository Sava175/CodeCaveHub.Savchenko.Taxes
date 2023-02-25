package com.taxes.domain;

import lombok.*;
import lombok.ToString.Exclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;
    public enum Position{MANAGER, DIRECTOR}
}
