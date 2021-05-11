package com.blj.javawiki.algorithm.other;

import java.util.*;

/**
 * 按频率排序
 * //输入一个无序整数数组，按整数出现次数从高到低排序？如 [1,2,3,3,4,5,2] => [2,2,3,3,1,4,5]
 * @author bailiangjin
 * @date 2021/5/11
 */
public class SortByFrequency {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3, 4, 5, 2};
        sort2(array);
        System.out.println(Arrays.asList(array));
    }


    public static void sort1(Integer[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i : array) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>();
        entryList.addAll(entrySet);
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(),o1.getValue());
            }
        });
        List<Integer> integerList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                integerList.add(entry.getKey());
            }
        }
        System.out.println(integerList);
    }
    public static void sort2(Integer[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        Map<Integer, Integer> map = new HashMap();

        for (int i : array) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return Integer.compare(map.get(o2), map.get(o1));
                if (!map.get(o1).equals(map.get(o2))) {
                    return Integer.compare(map.get(o2), map.get(o1));
                } else {
                    return Integer.compare(o2, o1);
                }
            }
        });
    }
}
