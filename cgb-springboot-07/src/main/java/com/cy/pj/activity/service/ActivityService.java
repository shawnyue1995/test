package com.cy.pj.activity.service;

import com.cy.pj.activity.pojo.Activity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ActivityService {
    List<Activity> findAll();

    void deleteById(Long id);

    int saveObject(Activity entity);

    List<Activity> findById(Long id);

    int update(Activity entity);
}
