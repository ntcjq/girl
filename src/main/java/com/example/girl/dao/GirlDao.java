package com.example.girl.dao;

import com.example.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlDao extends JpaRepository<Girl,Integer> {

    //自定义通过年龄查询
    List<Girl> findByAge(Integer age);
}
