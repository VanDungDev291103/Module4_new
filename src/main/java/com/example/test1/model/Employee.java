package com.example.test1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(columnDefinition = "Enum ('MALE', 'FEMALE', 'OTHER')")
    @Enumerated(EnumType.STRING)
    Gender gender;
    double salary;
    String phone;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department departmentId;

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}
