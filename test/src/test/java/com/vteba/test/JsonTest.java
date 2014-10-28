package com.vteba.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class JsonTest {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\g.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		String json = IOUtils.toString(fileInputStream);
		Object object = JSON.parse(json);
		System.out.println(object);
	}

}
