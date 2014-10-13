package com.vteba.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestResource {

	public static void main(String[] args) {
		String path = TestResource.class.getClassLoader().getResource("").getPath();
		System.out.println(path);
		path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(path);
		path = Thread.currentThread().getContextClassLoader().getResource("//").getPath();
		System.out.println(path);
		
		try {
			Connection connection = DriverManager.getConnection(null);
			connection.getMetaData();
			
			CallableStatement callableStatement = connection.prepareCall("{call tests(?,?)}");
			//callableStatement.setString(1, path);
			//callableStatement.registerOutParameter(parameterIndex, sqlType);
			callableStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
