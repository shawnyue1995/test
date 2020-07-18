package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysUserDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {
    int getRowCount(String username);

    List<SysUserDept> findPageObjects(String username, Integer startIndex, Integer pageSize);

    int validById(@Param("id") Integer id,
                  @Param("valid") Integer valid,
                  @Param("modifiedUser") String modifiedUser);
}
