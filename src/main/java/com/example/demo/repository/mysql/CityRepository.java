package com.example.demo.repository.mysql;

import com.example.demo.vo.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: java类作用描述
 * @Author: daishuai
 * @CreateDate: 2018/6/20 20:02
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public interface CityRepository extends JpaRepository<City, Integer>{
}
