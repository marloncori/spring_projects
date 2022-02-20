package com.jguides.student.registration.service;

import com.jguides.student.registration.exception.StudentAlreadySavedException;
import com.jguides.student.registration.exception.StudentNotFoundException;
import com.jguides.student.registration.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student getStudentById(Long id) throws StudentNotFoundException;

    List<Student> getAllStudents() throws StudentNotFoundException;

    void registerStudent(Student student) throws StudentAlreadySavedException;

    void updateStudent(Student newStudent, Long id) throws StudentNotFoundException;

    void deleteStudent(Long id) throws StudentNotFoundException;
}
