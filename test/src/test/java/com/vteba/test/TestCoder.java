package com.vteba.test;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.DB;
import com.vteba.ext.codegen.KeyType;
import com.vteba.ext.codegen.TempType;

public class TestCoder {

	public static void main(String[] args) {
	    //项目绝对路径
		String rootPath = "C:\\Users\\Administrator\\git\\test\\test\\";
		CodeBuilder builder = new CodeBuilder(rootPath, TempType.Generic);
		builder.setConfigFilePath("src/main/resources/config.properties")
		.schema("skmbw")
		.className("EmpUser")
		.setDb(DB.MySQL)
		.keyType(KeyType.Integer)
		.tableDesc("系统用户")
		.tableName("emp_user")
		.module("com.vteba.user2")
		.setPojo(false)
		.setMongo(false)
		.build();

	}

}
