package com.example.test1.repository;

import com.example.test1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> getAllDepartments();

    Optional<Department> findById(Integer departmentId);

    Department save(Department department);

    void delete(Integer departmentId);
}
