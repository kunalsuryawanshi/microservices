package com.microservice.service;

import com.microservice.entity.Department;
import com.microservice.exception.DepartmentException;
import com.microservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public String saveDepartment(Department department) {
        departmentRepository.save(department);
        System.out.println(department);
        return "Department Added Successfully";
    }

    public Department findDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}
