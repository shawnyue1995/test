package com.cy.pj;

import com.cy.pj.sys.pojo.SysRole;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JSONTest {
    @Test
    void testJSON() {
        System.out.println("{id:1,name:\"AA\",note:\"...\"}");
    }

    @Test
    void testJSON02() throws JsonProcessingException {
        SysRole role = new SysRole();
        role.setId(100);
        role.setName("HR");
        role.setNote("hr");
        //将对象转换为JSON格式字符串
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(role);
        System.out.println(jsonStr);

        //将字符串转换为对象
        om.readValue(jsonStr, SysRole.class);
        System.out.println(role);
    }
}
