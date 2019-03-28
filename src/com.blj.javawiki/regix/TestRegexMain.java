package com.blj.javawiki.regix;


/**
 * Created by bailiangjin on 16/3/2.
 */
public class TestRegexMain {

    public static void main(String[] args) {

        String str = "Hello";
        char[] chars = {'a', 'b', 'c'};

        System.out.println(str);
        System.out.println(chars);
        change(str, chars);
        System.out.println(str);
        System.out.println(chars);


        String regex="雨|雪|风|沙|尘|雷|电";
        String weather="电闪";

        System.out.println(weather.matches(regex));





    }

    public static void change(String str, char[] chars) {
        str = "Hello World";

        chars[0] = 'b';
        chars[1] = 'b';

    }

}
