package com.myway.tok.model;

public class Student {
	private Integer seq;
	private String id;
	private String name;
	private Integer age;
	public String getId() {
		return id;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [seq=" + seq + ", id=" + id + ", name=" + name + ", age=" + age + "]";
	}	
	
}
