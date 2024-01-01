package org.sk.rest;

import org.sk.service.EmployeeService;
import org.sk.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmpByID(@PathVariable Integer id) {
        Employee employee = employeeService.getByID(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found :" + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteById(@PathVariable Integer id) {
        Employee employee = employeeService.getByID(id);
        employeeService.deleteByID(id);
        return employee;
    }
}
