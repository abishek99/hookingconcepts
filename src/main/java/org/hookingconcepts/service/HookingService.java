package org.hookingconcepts.service;

import org.hookingconcepts.domain.Employee;
import org.hookingconcepts.repo.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "Employee")
public class HookingService {

    private static final Logger LOG = LoggerFactory.getLogger(HookingService.class);
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public String getMessage() {
        return "Welcome to Hooking Concepts";
    }

    @CachePut(value="Employee")
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

    @CachePut(value = "Employee", key = "#id")
    public Employee getEmployeeById(String id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Caching(evict = {@CacheEvict(value = "Employee"), @CacheEvict(value="Employee", key="#id")})
    public String deleteEmployeeById(String id) {
        Employee emp = employeeRepo.findById(id).orElse(null);
        if (emp!=null) {
            employeeRepo.deleteById(id);
            return "Deleted";
        } else {
            return "no data found";
        }
    }

    public String redisData() {
        String ans = "";
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        if (valueOperations.getOperations().hasKey("test")) {
            return (String) valueOperations.get("test");
        } else {
            ans = "data not found setting into redis now";
            valueOperations.setIfAbsent("test","data available in redis", Duration.ofMinutes(1L));
            return ans;
        }
    }
}
