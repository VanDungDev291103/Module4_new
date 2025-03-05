package com.example.test1.service;


import com.example.test1.dto.employee.EmployeeSearchRequest;
import com.example.test1.model.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findByAttributes(@Param("searchRequest") EmployeeSearchRequest searchRequest);

    Optional<Employee> findById(Integer id);

    Employee save(Employee employee);

    void delete(int id);
}
