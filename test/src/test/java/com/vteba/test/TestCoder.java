package com.vteba.test;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.DB;
import com.vteba.ext.codegen.KeyType;
import com.vteba.ext.codegen.TempType;

public class TestCoder {

	public static void main(String[] args) {
	    //项目绝对路径
		String rootPath = "C:/Users/Administrator/git/test/test/";
		CodeBuilder builder = new CodeBuilder(rootPath, TempType.Base);
		builder.setConfigFilePath("src/main/resources/config.properties")
		.setSrcPath("src/main/java/")
		.schema("public")
		.className("User")
		.setDb(DB.PostgreSQL)// 可以不使用，只要jdbc url是正确的
		.keyType(KeyType.String)
		.tableDesc("系统用户")
		.tableName("user")
		.module("com.vteba.finance.account")
		.setPojo(false)
		.setMongo(true)
		.build();

	}

}
