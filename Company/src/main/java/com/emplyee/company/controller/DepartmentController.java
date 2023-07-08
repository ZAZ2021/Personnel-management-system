package com.emplyee.company.controller;

import com.emplyee.company.mapper.DepartmentMapper;
import com.emplyee.company.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;

    //查找department表
    @GetMapping("/department")
    public List<Department> find(){
        return departmentMapper.findtable();
    }
}
