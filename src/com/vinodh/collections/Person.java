package com.vinodh.collections;

public class Person {
	
	public Person(){
		
	}

	public Person(int pId, String name, long phone) {
		super();
		this.pId = pId;
		this.name = name;
		this.phone = phone;
	}

	private int pId;
	private String name;
	private long phone;

	public int getpId() {
		return pId;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", name=" + name + ", phone=" + phone
				+ "]";
	}
	
	

}
