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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
}
