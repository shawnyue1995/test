package com.cy.pj.sys.dao;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleDao {

    int updateObject(SysRole entity);

    /**
     * 基于角色id执行角色数据查询操作
     *
     * @param id
     * @return
     */
    SysRoleMenu findObjectById(Integer id);

    int insertObject(SysRole entity);

    /**
     * 基于角色id删除用户和角色关系数据
     *
     * @param id
     * @return
     */
    int deleteObject(Integer id);

    /**
     * 基于角色进行角色信息的模糊查询
     */
    int getRowCount(@Param("name") String name);

    /**
     * 按条件分页查询角色记录
     *
     * @param name       角色名
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysRole> findPageObjects(@Param("name") String name,
                                  @Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize);

    /**
     * 查询角色id，name
     *
     * @return
     */
    List<CheckBox> findObjects();
}
