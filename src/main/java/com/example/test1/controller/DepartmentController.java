package com.example.test1.controller;//package com.techzen.academy.controller;


import com.example.test1.dto.ApiResponse;
import com.example.test1.exception.AppException;
import com.example.test1.exception.ErrorCode;
import com.example.test1.model.Department;
import com.example.test1.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/departments")
public class DepartmentController {

    IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        return departmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") int departmentId, @RequestBody Department department) {
        departmentService.findById(departmentId).orElseThrow(() ->  new AppException(ErrorCode.DEPARTMENT_NOT_EXIST));
        department.setId(departmentId);
        return ResponseEntity.ok(departmentService.save(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("departmentId") int departmentId) {
        departmentService.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXIST));
        departmentService.delete(departmentId);
        return ResponseEntity.noContent().build();
    }
}
