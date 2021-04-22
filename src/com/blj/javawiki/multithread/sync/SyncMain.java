package com.blj.javawiki.multithread.sync;

import java.util.concurrent.locks.Lock;

/**
 * Created by bailiangjin on 2017/7/10.
 */
public class SyncMain {

    //    private   volatile Integer number=0;
    private Integer number = 0;

    public static void main(String[] args) {

        final SyncMain syncMain = new SyncMain();
        SyncMain syncMain2 = new SyncMain();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 100 == 0) {
                        syncMain.countSyncClass("线程1");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 100 == 0) {
                        syncMain.countSyncValue("线程2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 100 == 0) {
                        syncMain.countSyncClass("线程3");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i % 100 == 0) {
                        syncMain.countSyncValue("线程4");
                    }
                }
            }
        }).start();

        Lock lock;

    }

    public synchronized void countSyncFunction(String threadName) {
        System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
    }

    public void countSyncValue(String threadName) {

        synchronized (number) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }

    public void countSyncObj(String threadName) {
        synchronized (this) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }

    public void countSyncClass(String threadName) {

        synchronized (SyncMain.class) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }

    public void countSyncClass2(String threadName) {

        synchronized (SyncMain.class) {
            System.out.println(threadName + " value=" + number++ + " time=" + System.currentTimeMillis());
        }
    }
}
