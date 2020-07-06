package com.cy.java.jvm.gc;
/**
 * 当GC系统没有启动时，对象是否可能被回收？可能，看你对象分配在哪了？
 * 说明：JAVA中大多数对象都会存储在堆(Heap)中，但对于一些没有逃逸的小对象
 * 现在也可能分配在栈上(JVM发展历程中的一种新的优化方式。)。
 */
public class TestGC03 {
    //-XX:+PrintGCDetails
	public static void main(String[] args) {
		for(int i=0;i<100000000;i++) {
			doMethod01();
		}
	}
	
	static byte[] b2;
	static void doMethod01() {
	   //小对象，未逃逸，栈上分配，栈上分配对象的对象，方法调用结束，对象销毁。
	   //byte[] b1=new byte[1024*1024]; //小对象，未逃逸(方法外界没有引用指向此对象)，可以直接分配在栈上
	   //小对象，已逃逸，堆上分配，对象回收需要借助GC系统。
	   b2=new byte[1];//小对象，但逃逸了(方法外部有引用指向此对象)，对象分配在堆上
	}
	//JDK8中默认会打开逃逸分析选项，希望未逃逸的小对象分配在栈上，这样可以避免启动GC对对象进行回收。
}
