package org.hookingconcepts.api;

import org.hookingconcepts.domain.Employee;
import org.hookingconcepts.service.HookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HookingApi {

    @Autowired
    private HookingService hookingService;

    @GetMapping("/getmessage")
    public String getMessage() {
        return hookingService.getMessage();
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(hookingService.saveEmployee(employee),HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(hookingService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(hookingService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeId(@PathVariable String id) {
        return  ResponseEntity.ok(hookingService.deleteEmployeeById(id));
    }

}
