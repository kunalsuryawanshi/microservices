package com.microservice.controller;

import com.microservice.entity.Department;
import com.microservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity saveDepartment(@RequestBody Department department) {
        System.out.println(department);
        return new ResponseEntity(departmentService.saveDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity findDepartmentById(@PathVariable int departmentId) {
        return new ResponseEntity(departmentService.findDepartmentById(departmentId), HttpStatus.OK);
    }
}
