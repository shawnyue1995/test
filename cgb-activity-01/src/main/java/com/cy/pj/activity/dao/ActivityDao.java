package com.cy.pj.activity.dao;

import com.cy.pj.activity.pojo.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityDao {

    @Select("select * from tb_activity")
    List<Activity> findActivitys();

    @Delete("delete from tb_activity where id=#{id}")
    int doDeleteById(Long id);

    int insertObject(Activity entity);


}