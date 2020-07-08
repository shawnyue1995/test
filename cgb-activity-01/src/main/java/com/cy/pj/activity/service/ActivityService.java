package com.cy.pj.activity.service;

import com.cy.pj.activity.pojo.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findActivitys();

    int doDeleteById(Long id);
}