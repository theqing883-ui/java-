package com.shp.map_;

import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //添加
        prop.put("key", "value");
        //prop.put(null, null);//NullPointerException
        prop.put("key2", "value2");
        prop.put("key2", "value3");//替换
        System.out.println(prop);

        //通过K获取V
        System.out.println(prop.get("key"));

        prop.remove("key");
        System.out.println(prop);


    }
}
