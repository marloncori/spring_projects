package net.javaguides.student_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.ui.ModelAttribute;
import net.javaguides.student_management.service.StudentService;

@Controller
public class Student Controller {

    StudentService studentService;

    //is there is only one contructor I can omit the Spring Bean annotation
    public StudentControler(StudentService studentService){
        this.studentService = studentService;
    }

    // handler method to handle showing students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    //this will return a front-end view of the listed students

    @PostMapping("/students/new")
    //create a student to hold student form data
    public String createStudentForm(Model model){
        var student = new Student(); 
        model.addAttribute("student", student);
        return "create_student";    
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        //save newly added student to the DB
        studentService.saveStudent(student);
        return "redirect:/students";       
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, 
            @ModelAttribute("student") Student student, Model model){
        //get student information from database by ID
        Student existingStudent = studentService.getStudentById(id);
            existingStudent.setId(id);
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //handler method to delete the requested student
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}