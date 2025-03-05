package com.example.test1.repository.impl;//package com.techzen.academy.repository.impl;
//
//import com.techzen.academy.dto.employee.EmployeeSearchRequest;
//import com.techzen.academy.model.Department;
//import com.techzen.academy.model.Employee;
//import com.techzen.academy.repository.IEmployeeRepository;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class aEmployeeRepository implements IEmployeeRepository {
//
//    @Override
//    public List<Employee> findByAttributes(EmployeeSearchRequest request) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//
//        // Sử dụng HQL
//        String hql = "FROM Employee e LEFT JOIN FETCH e.department WHERE "
//                + "(:name IS NULL OR Lower(e.name) LIKE CONCAT('%', :name, '%')) "
//                + "AND (:gender IS NULL OR e.gender = :gender) "
//                + "AND (:phone IS NULL OR e.phone LIKE CONCAT('%', :phone, '%')) "
//                + "AND (:departmentId IS NULL OR e.department.id = :departmentId)";
//
//
//        // Tạo đối tượng truy vấn
//        Query<Employee> query = session.createQuery(hql, Employee.class);
//
//        // Đặt giá trị tham số
//        query.setParameter("name", request.getName());
//        query.setParameter("gender", request.getGender());
//        query.setParameter("phone", request.getPhone());
//        query.setParameter("departmentId", request.getDepartmentId());
//
//        // Thực thi truy vấn và lấy danh sách kết quả
//        return query.getResultList();
//    }
//
//
//    @Override
//    public Employee findById(Integer id) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//        Employee employee = null;
//        try {
//            employee = (Employee) session.createQuery("FROM Employee WHERE id = :id")
//                    .setParameter("id", id)
//                    .uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return employee;
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            if (employee.getId() == null || findById(employee.getId()) == null) {
//                session.save(employee);
//            } else {
//                session.update(employee);
//            }
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            throw new RuntimeException(e);
//        } finally {
//            session.close();
//        }
//        return employee;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            Employee employee = findById(id);
//            if (employee != null) {
//                session.delete(employee);
//                session.getTransaction().commit();
//            } else {
//                throw new RuntimeException("không tìm tháy nhân viên với id: " + id);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            session.close();
//        }
//    }
//}
