package com.cy.pj.common.web;

/**
 * 通过此工具类封装对参数，执行过程，结果等业务的校验
 */
public class AssertUtil {
    /**
     * 验证参数的有效性
     *
     * @param statement
     * @param msg
     */
    public static void isArgumentValid(boolean statement, String msg) {
        if (statement) throw new IllegalArgumentException(msg);
    }

    public static void isResultValid(boolean statement, String msg) {
        if (statement) throw new IllegalArgumentException(msg);
    }
}
