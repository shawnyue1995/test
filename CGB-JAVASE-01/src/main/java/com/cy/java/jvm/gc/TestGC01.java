package com.cy.java.jvm.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义一个点对象类型
 */
class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	/**
	 * finalize方法会在对象被回收(GC)之前执行，可以对对象的回收进行监控，
	 * 也可以在对象回收之前进行一些资源释放操作。
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize()");
	}
}
//通过JVM参数检测是否触发了GC操作：-XX:+PrintGCDetails
public class TestGC01 {
	static Map<String,Object> objectPool=new HashMap<>();
	public static void main(String[] args) throws InterruptedException {
    	//构建一个实例对象，并通过P1引用指向这个对象
		 Point p1=new Point(10,20);//p1为一个强引用
		 objectPool.put("point", p1);//Spring中的singleton作用域
		 p1=null; //Spring中prototype作用域对象的销毁
		 objectPool.clear();//Spring中Singleton作用域的销毁
		//请问对于p1引用的这个对象何时会被标识垃圾对象，何时会被回收，如何确定此对象被回收了
		//1)当p1引用不再指向构建的Point对象时，此对象会被GC系统认为是垃圾对象。
		//2)当JVM系统触发了GC操作时，对象可能会被回收。
		//3)此对象会被JVM中的垃圾回收系统(GC系统)进行回收。(释放内存)
		//触发GC操作？(GC系统触发时会对内存中的对象进行可达性分析，就是检测是否还可以通过引用
		//访问到此对象，假如不能通过任何引用访问此对象，这个对象就会被标识垃圾)
		//1.手动GC
		//System.gc();
		//2.自动GC(满足了GC条件时或者说内存使用达到一定的GC启动标准)
		 List<byte[]> list=new ArrayList<>();
		 for(int i=0;i<100000;i++) {
			 list.add(new byte[1024*1024]);
		 }
	}
}




