/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.web;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
  @RequestMapping("/")
    
public class EmpController {
  @Autowired    
    EmpDao dao;//will inject dao from XML file    
    
     
  
        @RequestMapping("/")
    public String home() {
        return "index";
    }
  
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/empform")    
    public String showform(){    
     // m.addAttribute("command", new Emp());  
        return "empform";   
    }    
   
    @RequestMapping(value = "/save")
	public ModelAndView createEmp(@RequestParam("name") String name, @RequestParam("salary") String salary,
			@RequestParam("designation") String designation, ModelAndView mv) {
                Emp emp=new Emp();
		emp.setName(name);
                emp.setSalary(Integer.parseInt(salary));
                emp.setDesignation(designation);
		int counter = dao.save(emp);

		if (counter > 0) {
			mv.addObject("msg", "Employee registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}
		mv.setViewName("empform");

		return mv;
	}
 
         @RequestMapping(value = "/update")
	public  ModelAndView findEmpById(ModelAndView modal, @RequestParam("id") int id)
			throws IOException {
List<Emp> list = dao.findEmpById(id);
		
		

		modal.addObject("list", list);
		modal.setViewName("update");

		return modal;
        }
        @RequestMapping(value="/viewemp")    
    public String edit(@RequestParam("page") int pageid,Model m){    
        int total=5;    
        if(pageid==1){}    
        else{    
            pageid=(pageid-1)*total+1;    
        }    
      //  System.out.println(pageid);  
        List<Emp> list=dao.getEmployeesByPage(pageid,total);    
          m.addAttribute("msg", list);  
        return "viewemp";    
    }    
        
       @RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editEmp(HttpServletRequest req, ModelAndView mv) {
            int id=Integer.parseInt(req.getParameter("id"));
                       String name=req.getParameter("name");
            String salary=req.getParameter("salary");
           String designation=req.getParameter("designation");

            Emp emp=new Emp();
            emp.setId(id);
		emp.setName(name);
                emp.setSalary(Integer.parseInt(salary));
                emp.setDesignation(designation);
		int counter = dao.update(emp);
if (counter > 0) {
			mv.addObject("msg", "Employee detail updated successfully.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}
		mv.setViewName("update");

		return mv;
		
	}
 	
        @RequestMapping(value = "/read")
	public ModelAndView read(ModelAndView mv) throws IOException {

		List<Emp> list = dao.read();
		mv.addObject("list", list);
		mv.setViewName("read");

		return mv;
	}
    
        @RequestMapping(value = "/delete")
	public ModelAndView deleteStudentById(ModelAndView mv, @RequestParam("id")int id)
			throws IOException {
		int counter = dao.delete(id);

		if (counter > 0) {
			mv.addObject("msg", "Student records deleted against student id: " + id);
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("delete");

		return mv;
	}

     
	

	}

    
        
    
    
