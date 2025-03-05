package com.example.test1.repository;


import com.example.test1.dto.employee.EmployeeSearchRequest;
import com.example.test1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = """
            SELECT e.* FROM Employee e
            JOIN Department d on e.department_id = d.id
            WHERE (:name IS NULL OR e.name LIKE CONCAT('%', :name ,'%'))
            AND (:gender IS NULL OR e.gender = :gender)
            AND (:phone IS NULL OR e.phone LIKE CONCAT('%', :phone ,'%'))
            AND (:department_id IS NULL OR e.department_id = :department_id)
            AND (:salary IS NULL
                       OR (:salary = 'lt5' AND e.salary < 5000000)
                       OR (:salary = '5-10' AND e.salary BETWEEN 5000000 AND 10000000)
                       OR (:salary = '10-20' AND e.salary BETWEEN 10000000 AND 20000000)
                       OR (:salary = 'gt20' AND e.salary > 20000000))
            """, nativeQuery = true)
    List<Employee> findByAttributes(@Param("searchRequest") EmployeeSearchRequest searchRequest);
}
