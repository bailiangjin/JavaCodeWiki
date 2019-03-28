package com.blj.javawiki.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bailiangjin on 2017/7/15.
 */
public class ExecutorTest {
    public int number=0;
    public static void main(String[] args) {

      final   ExecutorTest executorTest =new ExecutorTest();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int count=i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    executorTest.numberAdd();
                    System.out.println("FixedThreadPool"+"excuteNumber="+count+"value="+ executorTest.number);
                }
            });
        }
       cachedThreadPool.execute(new Runnable() {
            public void run() {
                executorTest.numberDecrese();
                System.out.println("CachedThreadPool"+ executorTest.number);
            }
        });
       singleThreadExecutor.execute(new Runnable() {
            public void run() {
                executorTest.numberDecrese();
                System.out.println("SingleThreadExecutor"+ executorTest.number);
            }
        });

    }

    public synchronized void numberAdd(){
        number++;
    }

    public synchronized void numberDecrese(){
        number--;
    }

}
