package com.blj.javawiki.designpattern.factory;


/**
 * @author 白良锦 bailiangjin@gmail.com
 * @version 创建时间：2015年7月28日 上午10:38:11
 */
public class TestMain {
    public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        Work studentWork = studentWorkFactory.getWork();
        studentWork.doWork();

        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        Work teacherWork = teacherWorkFactory.getWork();
        teacherWork.doWork();
    }
}

