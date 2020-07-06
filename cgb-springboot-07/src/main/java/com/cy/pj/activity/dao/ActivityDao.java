package com.cy.pj.activity.dao;

import com.cy.pj.activity.pojo.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityDao {
    int insertObject(Activity entity);

    @Select("SELECT * FROM tb_activity order by createdTime desc")
    List<Activity> findAll();

    @Delete("Delete from tb_activity where id=#{id}")
    int deleteById(Long id);

    @Select("SELECT * FROM tb_activity where id=#{id}")
    Activity findById(Long id);

    int update(Activity entity);
}
