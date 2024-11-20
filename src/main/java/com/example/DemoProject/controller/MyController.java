package com.example.DemoProject.controller;

import com.example.DemoProject.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @RequestMapping(value="/path" ,method= RequestMethod.GET)
 public String message()
 {
     return "Welcome to Spring Boot Tutorials";
 }
    //    @PathVariable
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String message1(@PathVariable String name){
        return "Some Message: " + name;
    }
    //    @RequestParam
    @RequestMapping(value = "/param",method = RequestMethod.GET)
    public String message2(@RequestParam(defaultValue = "Param required") String fName, @RequestParam String lName){
        return "Request Param Example:  " + fName + " " + lName;
    }
    //    @RequestBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee){
        return employee;
    }
}
