package org.hookingconcepts.service;

import org.hookingconcepts.domain.Employee;
import org.hookingconcepts.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HookingService {

    private static final Logger LOG = LoggerFactory.getLogger(HookingService.class);
    @Autowired
    private EmployeeRepo employeeRepo;


    public String getMessage() {
        return "Welcome to Hooking Concepts";
    }

    public List<Employee> getAllEmployees() {
        LOG.info("=======inside the getAllEmployees");
        List<Employee> list = new ArrayList<>();
        employeeRepo.findAll().forEach(e->{
            list.add(e);
        });
        return list;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


}
