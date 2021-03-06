package com.cy.pj.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Node implements Serializable {
    private static final long serialVersionUID = 4828985081977733366L;

    private Integer id;
    private String name;
    private Integer parentId;
}
