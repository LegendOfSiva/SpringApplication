package org.sk.dao;

import org.sk.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getByID(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        return newEmployee;
    }

    @Override
    public void deleteByID(Integer id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }

}
