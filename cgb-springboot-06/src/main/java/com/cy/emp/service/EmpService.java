package com.cy.emp.service;

import com.cy.emp.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();
    void deleteById(Integer id);
    int insert(Emp emp);
    List<Emp> findById(Integer id);
    int update(Emp emp);
}
