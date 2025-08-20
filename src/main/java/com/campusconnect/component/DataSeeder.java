package com.campusconnect.component;

import com.campusconnect.entity.Department;
import com.campusconnect.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if(departmentRepository.count() == 0)
            seedDepartments();
    }

    private void seedDepartments() {
        List<Department> departments = Arrays.asList (
                new Department(null, "Computer"),
                new Department(null, "IT"),
                new Department(null, "ECS"),
                new Department(null, "EXTC"),
                new Department(null, "Mechanical"),
                new Department(null, "Automobile"),
                new Department(null, "Interdisciplinary & Common")
        );
        departmentRepository.saveAll(departments);
        System.out.println("✅ Departments seeded successfully!");
    }
}
