package com.cy.pj.activity.service;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> findAll() {
        List<Activity> list=activityDao.findAll();
        return list;
    }

    @Override
    public void deleteById(Long id) {
        int rows=activityDao.deleteById(id);
    }

    @Override
    public int saveObject(Activity entity) {
        return activityDao.insertObject(entity);
    }

    @Override
    public List<Activity> findById(Long id) {
        List<Activity> list=activityDao.findById(id);
        return list;
    }

    @Override
    public int update(Activity entity) {
        int rows=activityDao.update(entity);
        return rows;
    }
}
