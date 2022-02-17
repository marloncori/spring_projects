package net.javaguides.student_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.student_management.model.Student;
import net.javaguides.student_management.repository.StudentRepository;
import net.javaguides.student_management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    //this provide all the CRUD methods
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id){
        // add get method since it returns an Optional
        return studentRepository.findById(id).get();
    }
    
    @Override
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
    
}
