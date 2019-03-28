package com.blj.javawiki.designpattern.observer;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:54:56 
 *
 */
public class TianHePoliceman implements Policeman {
    @Override
    public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 天河警察出动!");
        }
    }
}
