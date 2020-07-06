package com.cy.java.debug;
/**
 * JAVA中的断点(Debug)过程分析：
 * 1)f8 当前断点运行结束，假如有下一个断点则直接跳转到下一个断点。
 * 2)f6 单步执行
 * 3)f5 进入调用的方法内部
 * 4)f7 从方法内部出去回到调用处。
 */
public class TestDebug01 {
	
	static void doMethod01() {
		System.out.println("===doMethod01()===");
		doMethod02();
	}
	static void doMethod02() {
		System.out.println("===doMethod02()===");
		doMethod03();
	}
	static void doMethod03() {
		System.out.println("===doMethod03()===");
	}

	public static void main(String[] args) {
		System.out.println("==main()===");
		doMethod01();
	}
}
