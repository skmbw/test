package com.vteba.test.proto;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vteba.protobuf.FirstProtobuf.SearchRequest;

// protoc.exe SearchRequest.proto --java_out=./
public class FirstProtoTest {
	private static byte[] bytes;
	
	@Test
	public void test() {
		long d = System.currentTimeMillis();
		SearchRequest.Builder builder = SearchRequest.newBuilder();// 这里很消耗性能
		builder.setPageNumber(32);
		builder.setQuery("yinlei尹雷");
		builder.setResultPerPage(10);
//		builder.setSamples(0, 2);
		
		SearchRequest searchRequest = builder.build();
		bytes = searchRequest.toByteArray();
		System.out.println(System.currentTimeMillis() - d);
	}
	
	@Test
	public void deser() {
		long d = System.currentTimeMillis();
		try {
			SearchRequest searchRequest = SearchRequest.parseFrom(bytes);
			searchRequest.getPageNumber();
			searchRequest.getQuery();
			searchRequest.getResultPerPage();
			searchRequest.getSamplesList();
		} catch (InvalidProtocolBufferException e) {
			
		}
		System.out.println(System.currentTimeMillis() - d);
	}
}
