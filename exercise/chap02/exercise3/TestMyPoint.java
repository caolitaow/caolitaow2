package com.md02;
public class TestMyPoint{
   public static void main(String[] args){
      MyPoint start=new MyPoint(10,10);
	  MyPoint end=new MyPoint(20,30);
	  System.out.println("start:"+start+'\n'+"end:"+end);
	  MyPoint stray=new MyPoint();
      stray=end;
	  System.out.println("end:"+end+'\n'+"stray:"+stray);
	  stray.setX(47);
	  stray.setY(50);
	  
	  System.out.println("start:"+start+'\n'+"end:"+end+'\n'+"stray:"+stray);
     MyPoint stray1;
	 stray1=end;
	 stray1.setX(07);
     stray1.setY(07);

	  System.out.println("start:"+start+'\n'+"end:"+end+'\n'+"stray:"+stray1);
   }


}
