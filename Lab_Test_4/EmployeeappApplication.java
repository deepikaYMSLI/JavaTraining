package com.employeeapp;

import com.employeeapp.dto.DeptEmpResponse;
import com.employeeapp.entities.Department;
import com.employeeapp.entities.Employee;
import com.employeeapp.repo.DepartmentRepo;
import com.employeeapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeappApplication {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Department d1 = new Department("Fin");
            Department d2 = new Department("IT");
            Department d3 = new Department("Sales");

            Employee emp1 = new Employee("Ravi", 6000.00, d1);
            Employee emp2 = new Employee("Ekta", 4000.00, d1);
            Employee emp3 = new Employee("Keshav", 7000.00, d2);
            Employee emp4 = new Employee("Gunika", 3400.00, d2);
            Employee emp5 = new Employee("Raj", 7800.00, d3);

            d1.getEmployees().add(emp1);
            d1.getEmployees().add(emp2);
            d2.getEmployees().add(emp3);
            d2.getEmployees().add(emp4);
            d3.getEmployees().add(emp5);

            departmentRepo.save(d1);
            departmentRepo.save(d2);
            departmentRepo.save(d3);

            employeeRepo.save(emp1);
            employeeRepo.save(emp2);
            employeeRepo.save(emp3);
            employeeRepo.save(emp4);
            employeeRepo.save(emp5);
        };
    }
}
