package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Person {
	
	
	private long id;
	
	@Size(min=2,message = "name should have atleast 2 charactor")
	private String name;
	
	@Max(value = 70,message = "enter valid age")
	private int age;
   
  
	private long phoneno;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person(long id, String name, int age, long phoneno) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneno = phoneno;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", phoneno=" + phoneno + "]";
	}

}
