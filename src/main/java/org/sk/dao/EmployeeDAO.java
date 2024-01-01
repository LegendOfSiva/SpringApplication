package org.sk.dao;

import org.sk.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee getByID(Integer id);

    Employee save(Employee employee);

    void deleteByID(Integer id);
}
