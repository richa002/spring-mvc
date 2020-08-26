/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.controller;

/**
 *
 * @author Acer
 */
import com.richa.model.Employee;
import com.richa.service.EmployeeService;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
 /*
    private static final Logger logger = Logger
            .getLogger(EmployeeController.class);
 
    public EmployeeController() {
        System.out.println("EmployeeController()");
    }
 */
    @Autowired
    private EmployeeService employeeService;
 
    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping("/newEmployee")
    public ModelAndView newContact(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }
 
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee, ModelAndView model) {
        // ModelAndView model = new ModelAndView();
       
        if (employee.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            employeeService.addEmployee(employee);
           model.addObject("msg","Employee detail added successfully");
       
        } else {
            model.addObject("msg","Employee detail updated successfully");
       
            employeeService.updateEmployee(employee);
        }
         model.setViewName("redirect:/");
   
        return model;
    }
 
     @RequestMapping("/welcome")
     public String welcomepage(){
     return "welcome";
     }
   
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request,ModelAndView model) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
       // return new ModelAndView("redirect:/");
   // ModelAndView model = new ModelAndView();
       model.addObject("msg","Detail deleted successfully");
        model.setViewName("redirect:/");
        return model;
    
    }
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);
 
        return model;
    }
 
}