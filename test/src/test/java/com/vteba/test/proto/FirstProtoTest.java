package com.vteba.test.proto;

import java.util.List;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vteba.protobuf.FirstProtobuf2.SearchRequest;

/**
 * 2.5.0版本的
 * @author  Administrator 
 * @see
 * @since
 */
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
		builder.addSamples(1);// list类型，或者数组类型
		builder.addSamples(2);
		
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
			List<Integer> samples = searchRequest.getSamplesList();
			System.out.println(samples);
		} catch (InvalidProtocolBufferException e) {
			
		}
		System.out.println(System.currentTimeMillis() - d);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
