package com.example.demo.controller;

import com.example.demo.repository.mysql.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 20:03
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/get/{id}")
    public Object getCity(@PathVariable("id") Integer id){
        return cityRepository.findOne(id);
    }

    @RequestMapping("/all")
    public Object getAll(){
        return cityRepository.findAll();
    }
}
