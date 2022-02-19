package b2.tech.employee_system.controller;

import b2.tech.employee_system.model.Employee;
import b2.tech.employee_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = employeeRepository.findAll();
        mav.addObject("employees", list);
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employeeToUpdate = employeeRepository.findById(employeeId).get();
            mav.addObject("employee", employeeToUpdate);
        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long id){
        employeeRepository.deleteById(id);
        return "redirect:/list";
    }
}
