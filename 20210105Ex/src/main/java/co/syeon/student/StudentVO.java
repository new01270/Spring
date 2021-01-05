package co.syeon.student;

import java.util.ArrayList;

public class StudentVO {
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private String height;

	public StudentVO(String name, int age, ArrayList<String> hobbys) {
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String toString() {
		System.out.println("학 생 명: " + name);
		System.out.println("학생 나이: " + age);
		System.out.println("학 생 키: " + height);
		System.out.println("-----학생 취미-----");

		for (String hobby : hobbys) {
			System.out.println(hobby);
		}

		return null;
	}

}
