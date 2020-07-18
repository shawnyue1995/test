package com.cy.pj.sys.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通过此对象封装角色以及角色对应的菜单id
 *
 * @author ta
 */

@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = 3005573447952589565L;
    private Integer id;
    private String name;
    private String note;
    /**
     * 角色对应的菜单id
     */
    private List<Integer> menuIds;
}
