package org.sk.service;

import org.sk.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee getByID(Integer id);

    Employee save(Employee employee);

    void deleteByID(Integer id);
}
