package com.jguides.student.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jguides.student.registration.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
