package com.example.test1.dto.employee;


import com.example.test1.model.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchRequest {
    Integer id;
    String name;
    Employee.Gender gender;
    double salary;
    String phone;
    Integer departmentId;
}
