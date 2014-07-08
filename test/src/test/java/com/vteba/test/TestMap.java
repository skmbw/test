package com.vteba.test;

import java.util.Map;

import com.google.common.collect.Maps;


public class TestMap {

    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("asd1aas", 1);
        map.put("asd2aaa", 2);
        map.put("user_name", "xingne");
        map.put("_sql_", "yigecal");
        map.put("age", 68L);
        
        long d = System.nanoTime();
        //map.get("_sql_").toString();
        //System.out.println(System.nanoTime() - d);
        
        //map.put("_sql_", "yigecaaaal");
        
        //d = System.nanoTime();
        map.remove("_sql_").toString();
        System.out.println(System.nanoTime() - d);
        
    }

}
