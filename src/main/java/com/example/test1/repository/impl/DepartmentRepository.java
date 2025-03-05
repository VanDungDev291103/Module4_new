package com.example.test1.repository.impl;//package com.techzen.academy.repository.impl;
//
//import com.techzen.academy.model.Department;
//import com.techzen.academy.model.Student;
//import com.techzen.academy.repository.IDepartmentRepository;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//public class DepartmentRepository implements IDepartmentRepository {
//
//    @Override
//    public List<Department> findAll() {
//        List<Department> departments;
//        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
//            departments = session.createQuery("FROM Department", Department.class).getResultList();
//        }
//        return departments;
//    }
//
//    @Override
//    public Department findById(Integer id) {
//        Session session = ConnectionUtil.sessionFactory.openSession();
//        Department department = null;
//        try {
//            department = (Department) session.createQuery("FROM Department WHERE id = :id")
//                    .setParameter("id", id)
//                    .uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return department;
//    }
//
//    @Override
//    public Department save(Department department) {
//        Transaction transaction = null;
//        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(department);
//            transaction.commit();
//            return department;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Transaction transaction = null;
//        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            Department department = (Department) session.createQuery("FROM Department WHERE id = :id")
//                    .setParameter("id", id)
//                    .uniqueResult();
//            if (department != null) {
//                session.delete(department);
//                transaction.commit();
//            } else {
//                throw new RuntimeException("Không tìm thấy phòng ban với ID: " + id);
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw new RuntimeException(e);
//        }
//    }
//}
