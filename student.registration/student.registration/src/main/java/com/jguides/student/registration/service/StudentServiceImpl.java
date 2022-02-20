package com.jguides.student.registration.service;

import com.jguides.student.registration.exception.StudentAlreadySavedException;
import com.jguides.student.registration.exception.StudentNotFoundException;
import com.jguides.student.registration.model.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jguides.student.registration.model.Student;
import com.jguides.student.registration.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private ErrorMessage msg;

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> maybeStudent = studentRepository.findById(id);
        if(!maybeStudent.isPresent()){
            throw new StudentNotFoundException(msg.getError1());
        }
        return maybeStudent.get();
    }

    public List<Student> getAllStudents() throws StudentNotFoundException {
        List<Student> students = studentRepository.findAll();
        Optional<List<Student>> maybeStudents = Optional.of(students);
        if(!maybeStudents.isPresent()){
            throw new StudentNotFoundException(msg.getError2());
        }
        return students;
    }

    public void registerStudent(Student student) throws StudentAlreadySavedException {
        List<Student> students = studentRepository.findAll();
        if(students.contains(student)){
            throw new StudentAlreadySavedException(msg.getError3());
        }
        studentRepository.save(student);
    }

    public void updateStudent(Student newStudent, Long id) throws StudentNotFoundException {
        Optional<Student> StudentInDB = studentRepository.findById(id);
        if(!StudentInDB.isPresent()) {
            throw new StudentNotFoundException(msg.getError1());
        }
        else {
            if(!StudentInDB.get().getFirstName().equals(newStudent.getFirstName())) {
                StudentInDB.get().setFirstName(newStudent.getFirstName());
            }
            if(!StudentInDB.get().getLastName().equals(newStudent.getLastName())) {
                StudentInDB.get().setLastName(newStudent.getLastName());
            }
            if(!StudentInDB.get().getEmail().equals(newStudent.getEmail())) {
                StudentInDB.get().setEmail(newStudent.getEmail());
            }
            if(!StudentInDB.get().getMobile().equals(newStudent.getMobile())) {
                StudentInDB.get().setMobile(newStudent.getMobile());
            }
            studentRepository.save(StudentInDB.get());
        }
    }

    public void deleteStudent(Long id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException(msg.getError1());
        }
        studentRepository.deleteById(id);
    }
}
