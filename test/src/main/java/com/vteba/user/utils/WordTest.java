package com.vteba.user.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vteba.user.servlet.Company;
import com.vteba.utils.date.DateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordTest {
    
    private Configuration configuration = null;
    
    public WordTest(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }
    
    public static void main(String[] args) {
        WordTest test = new WordTest();
        test.createWord();
        //FreeMarkerConfigurer configurer = null;
        //configurer.getConfiguration();
    }
    
    public void createWord(){
        Map<String,Object> dataMap=new HashMap<String,Object>();
        getData(dataMap);
        configuration.setClassForTemplateLoading(this.getClass(), "/");  //FTL文件所存在的位置
        Template t=null;
        try {
            t = configuration.getTemplate("w6.xml"); //文件名
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outFile = new File("e:/outFilessa"+Math.random()*10000+".doc");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
         
        try {
            t.process(dataMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getData(Map<String, Object> dataMap) {
        dataMap.put("title", "尹雷");
        dataMap.put("year", "2012");
        dataMap.put("month", "2");
        dataMap.put("day", "13");
        dataMap.put("auditor", "唐鑫");
        dataMap.put("phone", "13020265912");
        dataMap.put("weave", "占文涛");
//      dataMap.put("number", 1);
//      dataMap.put("content", "内容"+2);
        
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("number", i);
            map.put("content", "内容"+i);
            list.add(map);
        }
        
        Company company = new Company();
        company.setCompanyName("哦你敢保险");
        company.setNumber(222L);
        
        List<Company> fuList = new ArrayList<Company>();
        
        Company company2 = new Company();
        company2.setDatetime(DateUtils.toDateString("yyyy-MM-dd HH:mm"));
        company2.setReprint(22L);
        company2.setNumber(333L);
        company2.setSource("扯淡日报");
        company2.setSummary("好家伙打发阿斯顿，这里说的的都是摘要。好家伙打发阿斯顿，这里说的的都是摘要。好家伙打发阿斯顿，这里说的的都是摘要。");
        company2.setSourceFile("http://www.baidu.com");
        company2.setTitle("这个是标题");
        fuList.add(company2);
        
        company.setFuList(fuList);
        
        List<Company> zhengList = fuList;
        company.setZhengList(zhengList);
        
        company.setComList(fuList);
        
        List<Company> list2 = new ArrayList<Company>();
        list2.add(company);
        list2.add(company);
        
        dataMap.put("companyList", list2);
        //dataMap.put("all", company);
        //dataMap.put("fu", company2);
        
        dataMap.put("list", list);
    }
}

