package com.blj.javawiki.multithread.tongbu;

/**
 * Created by bailiangjin on 2017/7/10.
 */
public class Tongbu {

    //    private   volatile Integer number=0;
    private Integer number = 0;

    public static void main(String[] args) {

       final Tongbu tongbu = new Tongbu();
        Tongbu tongbu2 = new Tongbu();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    if (i % 100 == 0) {
                        tongbu.count("线程1");

                    }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    if (i % 100 == 0) {
                        tongbu.count2("线程2");
                    }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    if (i % 100 == 0) {
                        tongbu.count("线程3");
                    }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    if (i % 100 == 0) {
                        tongbu.count2("线程4");
                    }
            }
        }).start();


    }

    public void count(String threadName) {

        synchronized (number) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }

    public void count2(String threadName) {

        synchronized (number) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }
}
