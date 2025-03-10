package com.example.test1.service.impl;

import com.example.test1.dto.employee.EmployeeSearchRequest;
import com.example.test1.model.Employee;
import com.example.test1.repository.IEmployeeRepository;
import com.example.test1.service.IEmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findByAttributes(EmployeeSearchRequest searchRequest, Pageable pageable) {
        return employeeRepository.findByAttributes(searchRequest,pageable);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
