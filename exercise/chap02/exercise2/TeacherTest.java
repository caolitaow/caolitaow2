package com.md02;
public class TeacherTest 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher();
		
		t.name = "George";
		t.age = 30;
		t.salary = 10000;

		System.out.println("name=" + t.name);
		System.out.println("age=" + t.age);
		System.out.println("salary=" + t.salary);

		t.increaseAge();
		System.out.println("new age=" + t.age);
		t.increaseSalary1();
		System.out.println("new salary="+t.salary);
	}
}
