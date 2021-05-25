package com.blj.javawiki.datastructure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * //TODO 添加类注释
 *
 * @author bailiangjin
 * @date 2021/5/24
 */
public class TestArrayListMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);
        System.out.println(list.hashCode());
        System.out.println(synchronizedList.hashCode());
    }
}
