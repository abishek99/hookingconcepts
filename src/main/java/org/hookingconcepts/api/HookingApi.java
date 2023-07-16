package org.hookingconcepts.api;

import org.hookingconcepts.domain.Employee;
import org.hookingconcepts.service.HookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HookingApi {

    @Autowired
    private HookingService hookingService;

    @GetMapping("/getmessage")
    public String getMessage() {
        return hookingService.getMessage();
    }

    @GetMapping("/save")
    public ResponseEntity<Employee> saveEmployee() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setAge("24");
        employee.setLocation("Bangalore");
        employee.setRole("AssociateConsultant");
        employee.setName("Abishek S");
        return new ResponseEntity<>(hookingService.saveEmployee(employee),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(hookingService.getAllEmployees(), HttpStatus.OK);
    }
}
