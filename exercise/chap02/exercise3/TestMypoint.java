package com.md02;
public class TestMyPoint{
   public static void main(String[] args){
      MyPoint start=new MyPoint(10,10);
	  MyPoint end=new MyPoint(20,30);
	  System.out.println("start:"+start+'\n'+"end:"+end);
	  MyPoint stray=end;

	  System.out.println("end:"+end+'\n'+"stray:"+stray);
	  stray.MyPoint(47,50);
	  System.out.println("start:"+start+'\n'+"end:"+end+'\n'+"stray:"+stray);
     
   }


}
