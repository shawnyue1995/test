package com.cy.java.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * FAQ:
 * 1)当对象存在引用时，是否可能在系统触发GC时被回收？可能，要看引用类型？
 * 2)当GC系统触发时，假如对象要被销毁了会执行finalize方法吗？会的。
 * 
 * JVM GC 系统
 * 1)市场常见GC算法？(不限于java平台)
 * 2)JVM中常见GC算法？(不同规范的实现，算法不相同)
 * 3)JVM规范的实现HotSpot虚拟机有什么GC算法的应用？具体应用场景有什么不同。
 */
class Container{
	private Object[] array;
	public Container(int cap) {
		this.array=new Container[cap];
	}
	//....
	@Override
	protected void finalize() throws Throwable {
		System.out.println("==finalize()==");
	}
}
public class TestGC02 {

    public static void main(String[] args) {
    	doMethod01();
	}
	/**
	 * 在JAVA中我们可以使用的对象引用方式有四种：
	 * 1)强引用:此引用引用的对象,生命力最强。(对象不会被GC)
	 * 2)软引用:此引用引用的对象，在内存不足时可能会被GC。
	 * 3)弱引用:此引用引用的对象，在GC执行时可能直接会被销毁(即便是内存充足)。
	 * 4)虚引用:用的最少，类似没有引用，主要用于记录对象的销毁。---了解
	 * 
	 * 说明：软引用和弱引用通常会应用在一些缓存产品的设计中。
	 */
	private static void doMethod01() {
		//1.强引用
    	//Container c1=new Container(100);//c1就是强引用
    	//c1=null;//此时c1指向的Container对象不可达(也就是说JVM访问不到了)
    	//2.软引用
    	//SoftReference<Container> c2=new SoftReference<Container>(new Container(20));
    	//Container cc=c2.get();//这种写发是又将软引用转换为了强引用。不推荐
    	//System.out.println(c2.get());//通过软引用获取和操作对象
    	//3.弱引用
    	WeakReference<Container> c3=new WeakReference<Container>(new Container(100));
    	System.out.println(c3.get());
    	
    	//手动GC
    	System.gc();//GC启动以后，GC系统会对内存中的对象进行可达性分析。访问不到则进行标记。
    	//自动GC(通过JVM参数进行分析)
//    	List<byte[]> list=new ArrayList<>();
//    	for(int i=0;i<100000;i++) {
//    		list.add(new byte[1024*1024]);
//    	}
	}
}






