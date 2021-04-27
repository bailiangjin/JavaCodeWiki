package com.blj.javawiki.designpattern.factory;


/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:42:04 
 *
 */
public class TeacherWorkFactory implements IWorkFactory {
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
