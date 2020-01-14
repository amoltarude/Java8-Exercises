package com.sort.students;

public class Student {
	private String name;
	private int percentage ;
	
	public Student(){
		
	}

	public Student(String name, int percentage) {
		super();
		this.name = name;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", percentage=" + percentage + "]";
	}
	
	
}
