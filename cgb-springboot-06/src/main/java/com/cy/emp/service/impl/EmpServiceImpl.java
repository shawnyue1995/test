package com.cy.emp.service.impl;

import com.cy.emp.dao.EmpDao;
import com.cy.emp.pojo.Emp;
import com.cy.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> findAll() {
        List<Emp> list=empDao.findAll();
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        int rows=empDao.deleteById(id);
    }

    @Override
    public int insert(Emp emp) {
        int rows=empDao.insert(emp);
        return rows;
    }

    @Override
    public List<Emp> findById(Integer id) {
        List<Emp> list=empDao.findById(id);
        return list;
    }

    @Override
    public int update(Emp emp) {
        int rows=empDao.update(emp);
        return rows;
    }

}
