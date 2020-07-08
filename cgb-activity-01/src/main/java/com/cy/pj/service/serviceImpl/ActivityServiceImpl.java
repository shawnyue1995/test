package com.cy.pj.service.serviceImpl;

import com.cy.pj.dao.ActivityDao;
import com.cy.pj.pojo.Activity;
import com.cy.pj.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> findAll() {
        List<Activity> list = activityDao.findAll();
        return list;
    }

    @Override
    public void deleteById(Long id) {
        int rows = activityDao.deleteById(id);
    }

    @Override
    public int saveObject(Activity entity) {
        return activityDao.insertObject(entity);
    }

    @Override
    public Activity findById(Long id) {
        return activityDao.findById(id);
    }

    @Override
    public int update(Activity entity) {
        return activityDao.update(entity);
    }
}
