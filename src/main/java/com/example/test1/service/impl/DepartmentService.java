package com.example.test1.service.impl;

import com.example.test1.model.Department;
import com.example.test1.repository.IDepartmentRepository;
import com.example.test1.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService implements IDepartmentService {
    IDepartmentRepository iDepartmentRepository;

    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return iDepartmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return iDepartmentRepository.save(department);
    }

    @Override
    public void delete(int department) {
        iDepartmentRepository.deleteById(department);
    }
}
