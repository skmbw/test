package com.vteba.test;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.KeyType;

public class TestCoder {

	public static void main(String[] args) {
	    //项目绝对路径
		String rootPath = "C:\\Users\\Administrator\\git\\test\\test\\";
		CodeBuilder builder = new CodeBuilder(rootPath);
		builder.schema("skmbw")
		.className("EmpUser")
		.keyType(KeyType.Integer)
		.tableDesc("系统用户")
		.tableName("emp_user")
		.module("user2")
		.build();

	}

}
