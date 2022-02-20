package com.jguides.student.registration.controller;

import com.jguides.student.registration.exception.StudentAlreadySavedException;
import com.jguides.student.registration.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jguides.student.registration.exception.StudentNotFoundException;
import com.jguides.student.registration.service.StudentService;
import java.util.Collections;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudents(Model model) throws StudentNotFoundException {
        model.addAttribute("students", Collections.unmodifiableList(studentService.getAllStudents()));
        return "students";
    }

    @GetMapping("/students/new")
    public String registerStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "register_student";
    }

    @PostMapping("/students")
    public String saveRegisteredStudent(@ModelAttribute("student") Student student) throws StudentAlreadySavedException {
        studentService.registerStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) throws StudentNotFoundException {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student, Model model) throws StudentNotFoundException {
        Student savedStudent = studentService.getStudentById(id);
        if(savedStudent != student){
            studentService.updateStudent(student, id);
        }
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
