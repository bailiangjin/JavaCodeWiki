package com.blj.javawiki.demo;

import com.bailiangjin.javabaselib.modle.PersonBean;
import java.util.ArrayList;
import java.util.List;

public class GsonParse {

    class City {

        int id;

        private String name;

        private String code;

        private String map;

    }

    public static void main(String[] args) {

        // Gson gson = parseListJson();
        //
        // paseMapJson(gson);
        List<PersonBean> list = new ArrayList<PersonBean>();
        for (int i = 0; i < 10; i++) {
            PersonBean bean = new PersonBean();
            bean.setId(i);
            bean.setName("name" + i);
            bean.setAge(i);
            list.add(bean);
        }

//		String listJson = GsonUtils.getInstance().parseObj2Json(list);
//		System.out.println(listJson);
//		List<PersonBean> listp = GsonUtils.getInstance().parsJson2List(listJson);
//		for (PersonBean personBean : listp)
//		{
//		}.getType());
//
//		System.out.println(cityMap.get("1").name + "----------" + cityMap.get("2").code);
    }
}
//
//	private static Gson parseListJson()
//	{
//		// 列表/array 数据
//
//		String listJson = "[{'id': '1','code': 'bj','name': '北京','map': '39.90403, 116.40752599999996'}, {'id': '2','code': 'sz','name': '深圳','map': '22.543099, 114.05786799999998'}, {'id': '9','code': 'sh','name': '上海','map': '31.230393,121.473704'}, {'id': '10','code': 'gz','name': '广州','map': '23.129163,113.26443500000005'}]";
//
//		Gson gson = new Gson();
//
//		List<City> list = new ArrayList<City>();
//
//		Type type = new TypeToken<ArrayList<City>>()
//		{
//		}.getType();
//
//		list = gson.fromJson(listJson, type);
//
//		for (City o : list)
//		{
//			System.out.println(o.name);
//		}
//		return gson;
//	}
//
//}