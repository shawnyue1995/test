package com.cy.pj.sys.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Base64;
import java.util.UUID;

@SpringBootTest
public class MD5Test01 {
    /**
     * MD5：消息摘要加密算法，其特点：
     * 1）不可逆，但可以暴力破解
     * 2）相同内容加密结果相同
     */
    @Test
    void testMd501() {
        String pwd = "123456";
        //String salt="ABCD";
        String salt = UUID.randomUUID().toString();
        //基于spring框架中的 DigestUtils工具类进行密码加密
        String hashedPwd = DigestUtils.md5DigestAsHex((pwd + salt).getBytes());
        String hashedPwd2 = DigestUtils.md5DigestAsHex((pwd + salt).getBytes());
        System.out.println(hashedPwd);//e10adc3949ba59abbe56e057f20f883e
        System.out.println(hashedPwd2);//e10adc3949ba59abbe56e057f20f883e
        //多次加密
        String hashedPwd3 = DigestUtils.md5DigestAsHex((hashedPwd).getBytes());
        System.out.println(hashedPwd3);
    }

    /**
     * base64是一种可逆的加密算法，其特点：
     * 1）可逆（加密以后可以将内容转换为64进制）
     * 2）加密结果的长度随待加密内容可变
     */
    @Test
    void testBase64() {//Base64为一种可逆的算法
        String pwd = "123456";
        //获得一个加密对象
        Base64.Encoder encoder = Base64.getEncoder();
        String base64Pwd = encoder.encodeToString(pwd.getBytes());
        System.out.println(base64Pwd);
        //获得一个解密对象
        Base64.Decoder decoder = Base64.getDecoder();
        String decoderStr = new String(decoder.decode(base64Pwd.getBytes()));
        System.out.println(decoderStr);
    }
}
