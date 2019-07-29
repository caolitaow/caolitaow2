package com.md02;

public class Teacher
{
	public String name;		
	public int age;			
	public double salary;	
    
	public void increaseAge(){
		age++;
	}
	public double increaseSalary(){
		salary+=5000.0;
		return salary;
	
	}
	public void increaseSalary1(){
	   salary+=5000;
	}
	public String toString(){
		return "name:"+name+",age:"+age+",salary:"+salary;
	}

}
