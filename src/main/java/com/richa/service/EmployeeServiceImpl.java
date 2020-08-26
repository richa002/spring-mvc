/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.service;

/**
 *
 * @author Acer
 */
import com.richa.dao.EmployeeDAO;
import com.richa.model.Employee;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeDAO employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }
 
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDAO.updateEmployee(employee);
    }
 
 
}
