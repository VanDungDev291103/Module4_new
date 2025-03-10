package com.example.test1.controller;

import com.example.test1.dto.employee.EmployeeSearchRequest;
import com.example.test1.dto.page.PageResponse;
import com.example.test1.exception.AppException;
import com.example.test1.exception.ErrorCode;
import com.example.test1.model.Employee;
import com.example.test1.service.impl.EmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/employees")
public class EmployeeManagementController {

    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployeeAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) {
        return ResponseEntity.ok(new PageResponse<>(employeeService.findByAttributes(employeeSearchRequest,pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employee.setId(id);
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
