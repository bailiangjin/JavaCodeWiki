package com.blj.javawiki.designpattern.factory;


/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:35:29 
 *
 */
public class StudentWork implements Work {
    @Override
    public void doWork() {
        System.out.println("学生做作业!");
    }
}