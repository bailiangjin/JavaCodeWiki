package com.blj.javawiki.designpattern.singleton.inner;

public class Singleton {

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
}