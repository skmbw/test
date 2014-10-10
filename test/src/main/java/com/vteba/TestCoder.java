package com.vteba;


import org.mybatis.generator.GenMain;

import com.vteba.ext.codegen.CodeBuilder;
import com.vteba.ext.codegen.DB;
import com.vteba.ext.codegen.KeyType;
import com.vteba.ext.codegen.TempType;

public class TestCoder {

	public static void main(String[] args) {
	    //项目绝对路径
		String rootPath = "C:\\Users\\Administrator\\git\\test\\test\\";
		CodeBuilder builder = new CodeBuilder(rootPath, TempType.Mybatis);
		builder.setConfigFilePath("src/jndi.properties")
		.setSrcPath("src/main/java/")
		.schema("skmbw")
		.className("ShardsTable")
		.setDb(DB.MySQL)// 可以不使用，只要jdbc url是正确的
		.keyType(KeyType.Integer)
		.tableDesc("分区表")
		.tableName("shards_table")
		.module("com.vteba.table")
		.setPojo(false)
		.setMongo(false)
		.setGenAction(false)
        .setGenDao(false)
        .setGenMapper(false)
        .setGenModel(false)
        .setGenService(false)
        .setMybatisShards(true)
		.build();

		GenMain.main(rootPath);
	}

}
