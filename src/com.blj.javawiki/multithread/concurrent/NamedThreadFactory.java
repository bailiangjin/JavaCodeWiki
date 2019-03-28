package com.blj.javawiki.multithread.concurrent;

import com.blj.javawiki.utils.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 带命名的线程工厂
 *
 * @author bailiangjin
 * @date 2019/3/18
 */
public class NamedThreadFactory implements ThreadFactory {

    /**
     * 原子操作保证每个线程都有唯一的
     */
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String prefix;

    /**
     * 是否为守护进程
     */
    private final boolean daemonThread;

    private final ThreadGroup mThreadGroup;

    public NamedThreadFactory() {
        this("Kevin-ThreadPool", false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }


    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = StringUtils.isEmpty(prefix) ? "" : prefix + "-thread-";
        daemonThread = daemon;
        SecurityManager s = System.getSecurityManager();
        mThreadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + mThreadNum.getAndIncrement();
        Thread thread = new Thread(mThreadGroup, runnable, name, 0);
        thread.setDaemon(daemonThread);
        return thread;
    }
}