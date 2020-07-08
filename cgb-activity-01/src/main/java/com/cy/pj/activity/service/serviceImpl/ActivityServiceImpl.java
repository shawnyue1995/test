package com.cy.pj.activity.service.serviceImpl;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> findActivitys() {
        return activityDao.findActivitys();
    }

    @Override
    public int doDeleteById(Long id) {
        int rows = activityDao.doDeleteById(id);
        return rows;
    }

    @Override
    public int saveObject(Activity entity) {
        int rows = activityDao.insertObject(entity);
        return rows;
    }

}