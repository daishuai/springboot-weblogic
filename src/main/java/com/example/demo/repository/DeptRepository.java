package com.example.demo.repository;

import com.example.demo.vo.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 14:53
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public interface DeptRepository extends JpaRepository<Department,Integer>{
}
