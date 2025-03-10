package com.example.test1.service;


import com.example.test1.dto.employee.EmployeeSearchRequest;
import com.example.test1.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findByAttributes(@Param("searchRequest") EmployeeSearchRequest searchRequest, Pageable pageable);

    Optional<Employee> findById(Integer id);

    Employee save(Employee employee);

    void delete(int id);
}
