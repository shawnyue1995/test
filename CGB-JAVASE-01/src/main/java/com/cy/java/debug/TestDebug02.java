package com.cy.java.debug;
/**
 * 断点分析Integer类中的valueOf方法
 * @author qilei
 */
public class TestDebug02 {
	public static void main(String[] args) {
		Integer a1=100;//等号右边的代码编译时执行的操作是Integer.valueOf(100);
		Integer a2=100;
		Integer a3=200;//Integer.valueOf(200),池中没有则new Integer(200)
		Integer a4=200;
		System.out.println(a1==a2);//true,Integer类有一个整数池，池中存储了-128~+127
		System.out.println(a3==a4);//false，池中没有，它会重新new Integer(200);
	}
}

