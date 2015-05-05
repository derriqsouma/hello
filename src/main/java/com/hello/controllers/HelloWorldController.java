package com.hello.controllers;

import com.hello.models.Employee;
import com.hello.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by derric on 5/4/15.
 */

@Controller
public class HelloWorldController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = {"/", "/index" }, method = RequestMethod.GET)
    public String helloWorld(Model model){

        model.addAttribute("msg","hello world");

        return "index";
    }

    
    @RequestMapping("/create")
    public ModelAndView create(@RequestParam(value = "fname", required = false) String fname,
                               @RequestParam(value = "lname", required = false) String lname,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "phone", required = false) String phone){
        ModelAndView model = new ModelAndView();
        Employee employee = new Employee();
        employee.setFirst_name(fname);
        employee.setLast_name(lname);
        employee.setEmail(email);
        employee.setPhone(phone);
        employeeService.insertRow(employee);
        
        model.addObject("employeeList", employeeService.getList());
        model.setViewName("list");
        return model;
    }

    @RequestMapping("/list")
    public ModelAndView getList(){
        ModelAndView model = new ModelAndView();

        List<Employee> employeeList = employeeService.getList();
        model.addObject("employeeList", employeeList);
        model.setViewName("list");
        return model;
    }
}
