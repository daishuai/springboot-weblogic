package com.example.demo.controller;

import com.example.demo.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 14:55
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@RestController
public class DeptController {

    @Autowired
    private DeptRepository deptRepository;

    @RequestMapping("/dept/{id}")
    public Object getDept(@PathVariable("id") Integer id){
        return deptRepository.findOne(id);
    }

    @RequestMapping("/all")
    public Object getAll(){
        return deptRepository.findAll();
    }
}
