//package com.blj.javawiki.annotation.runtime;
//
//
//import java.lang.reflect.Method;
//
//public class TestTool {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        NoBug testobj = new NoBug();
//
//        Class clazz = testobj.getClass();
//
//        Method[] methods = clazz.getDeclaredMethods();
//        //用来记录测试产生的 log 信息
//        StringBuilder log = new StringBuilder();
//        // 记录异常的次数
//        int errornum = 0;
//
//        for ( Method method: methods ) {
//            // 只有被 @Jiecha 标注过的方法才进行测试
//            if ( method.isAnnotationPresent( Jiecha.class )) {
//                try {
//                    method.setAccessible(true);
//                    method.invoke(testobj, null);
//
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    //e.printStackTrace();
//                    errornum++;
//                    log.append(method.getName());
//                    log.append(" ");
//                    log.append("has error:");
//                    log.append("\n\r  caused by ");
//                    //记录测试过程中，发生的异常的名称
//                    log.append(e.getCause().getClass().getSimpleName());
//                    log.append("\n\r");
//                    //记录测试过程中，发生的异常的具体信息
//                    log.append(e.getCause().getMessage());
//                    log.append("\n\r");
//                }
//            }
//        }
//
//
//        log.append(clazz.getSimpleName());
//        log.append(" has  ");
//        log.append(errornum);
//        log.append(" error.");
//
//        // 生成测试报告
//        System.out.println(log.toString());
//
//    }
//
//}