package org.hookingconcepts.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Employee")
public class Employee implements Serializable {

    @Id
    private String id;
    private String name;
    private String age;
    private String role;
    private String location;

    public Employee(String id, String name, String age, String role, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.location = location;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
