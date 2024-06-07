package com.example.demo.Controller;

import com.example.demo.Entity.Employe;
import com.example.demo.Entity.Project;
import com.example.demo.Service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/getemployees")
    public List<Employe> getAllEmployees() {
        return employeService.getAllEmployees();
    }

    @PostMapping("/saveemployees")
    public void addEmployee(@RequestBody Employe employe) {
        employeService.addEmploye(employe);
    }
    @DeleteMapping("/delete")
    public void deleteProject(@RequestBody Employe emp) {
        employeService.deleteemploye(emp);
    }
}
