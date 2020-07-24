package com.cy.java.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义异步池
 */
public class ThreadPoolTests {
    public static void main(String[] args) {

        BlockingQueue<Runnable> workQueue=new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory=new ThreadFactory() {
            AtomicLong al=new AtomicLong(1);

            @Override
            public Thread newThread(Runnable r) {
                String name="cgb2004-thread-"+al.incrementAndGet();
                return new Thread(r,name);
            }
        };

        ThreadPoolExecutor tExecutor=new ThreadPoolExecutor(
                2,//corePoolSize核心线程数
                3,//maximumPoolSize最大线程数
                60,//keepAliveTime线程空闲多长时间
                TimeUnit.SECONDS,//unit时间单位
                workQueue,//workQueue工作队列
                threadFactory,//threadFactory线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy());//拒绝执行任务的一种策略，CallerRunsPolicy表示有调用者线程去执行
        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-01");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-02");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-03");
            }
        });
        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-04");
            }
        });
        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-05");
            }
        });
        tExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->task-06");
            }
        });
    }
}
