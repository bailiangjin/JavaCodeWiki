package com.blj.javawiki.designpattern.abstractfactory;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午3:15:48 
 *
 */
public class WhiteDog implements IDog {
    @Override
    public void eat() {
        System.out.println("The white dog is eating!");
    }
}
