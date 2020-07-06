package com.cy.emp.dao;

import com.cy.emp.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface EmpDao {
    @Select("SELECT id,name,job,salary FROM emp")
    List<Emp> findAll();

    @Delete("delete from emp where id=#{id}")
    int deleteById(Integer id);

    @Insert("insert into emp (name,job,salary) values(#{name},#{job},#{salary})")
    int insert(Emp emp);

    @Select("SELECT * FROM emp where id=#{id} ")
    List<Emp> findById(Integer id);
    int update(Emp emp);
}
