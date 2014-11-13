package com.vteba.test.proto;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.vteba.protobuf.AddressBookProtos.AddressBook;
import com.vteba.protobuf.AddressBookProtos.Person;
import com.vteba.protobuf.AddressBookProtos.Person.PhoneNumber;
import com.vteba.protobuf.AddressBookProtos.Person.PhoneType;

/**
 * 这个测试的是2.6.1版本的
 * @author  Administrator 
 * @see
 * @since
 */
public class AddBookProto {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		long d = System.currentTimeMillis();
		AddressBook.Builder builder = AddressBook.newBuilder();
		
		Person.Builder personBuilder =  Person.newBuilder();
		personBuilder.setEmail("tongku2008@126.com");
		personBuilder.setId(2014);
		personBuilder.setName("尹雷yinlei");
		
		PhoneNumber.Builder phoneNumberBuilder = PhoneNumber.newBuilder();
		phoneNumberBuilder.setNumber("13815712222");
		phoneNumberBuilder.setType(PhoneType.HOME);
		
		personBuilder.addPhone(phoneNumberBuilder);
		
		Person person = personBuilder.build();
		builder.addPerson(person);
		
		AddressBook addressBook = builder.build();
		byte[] bytes = addressBook.toByteArray();
		System.out.println("序列化：" + (System.currentTimeMillis() - d));
		
		d = System.currentTimeMillis();
		AddressBook addressBook2 = null;
		try {
			addressBook2 = AddressBook.parseFrom(bytes);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		Person person2 = addressBook2.getPerson(0);
		String email = person2.getEmail();
		person2.getId();
		String name = person2.getName();
		PhoneNumber phoneNumber = person2.getPhone(0);
		phoneNumber.getNumber();
		phoneNumber.getType();
		System.out.println("反序列化：" + (System.currentTimeMillis() - d));
		
	}
	
}
