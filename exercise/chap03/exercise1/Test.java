import java.util.Scanner;
public class Test{
	public int num1;
	public int num2;
	public void keyboardInputNum1(){
	   
		this.num1=Integer.parseInt(new Scanner(System.in).next());
	}
	public void keyboardInputNum2(){
		this.num2=Integer.parseInt(new Scanner(System.in).next());
	
	}
	
	public void l8bitclear(int num){
		System.out.println("Hex:"+(Integer.toHexString(num&0xffffff00)));
		System.out.println("Dec:"+(num&0xffffff00));
        	
	}
	public void l16bitbe1(int num){
	    System.out.println("Hex:"+(Integer.toHexString(num|0x0000ffff)));
		System.out.println("Dec:"+(num|0x0000ffff));
	}
    public void intSwap(){
	    
		System.out.println("Please input two numbers need to be swaped:");
		System.out.print("num1=");
	    keyboardInputNum1();	
		System.out.print("num2=");
        keyboardInputNum2();
		num2=num1^num2;
		num1=num1^num2;
	    num2=num2^num1;
		System.out.println("num1="+num1+'\n'+"num2="+num2);
	}
    public void weekSwitch(){
		keyboardInputNum1();
		switch(num1){
			case 0:System.out.println("星期天");
				   break;
			case 1:System.out.println("星期一");
				   break;
			case 2:System.out.println("星期二");
				   break;
			case 3:System.out.println("星期三");
                   break;
			case 4:System.out.println("星期四");
				   break;
			case 5:System.out.println("星期五");
				   break;
			case 6:System.out.println("星期六");
				   break;
			default:System.out.println("Error!");
				   
		}
	    
	
	}
	public static void main(String[] args){
		Test t=new Test();
		t.l8bitclear(0x12345678);
	    t.l16bitbe1(0x12345678);
	    t.intSwap();
		t.weekSwitch();
	}




}