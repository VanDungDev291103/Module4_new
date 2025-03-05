package com.example.test1.service;


import com.example.test1.model.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Integer id);
    Department save(Department department);
    void delete(int department);

}
