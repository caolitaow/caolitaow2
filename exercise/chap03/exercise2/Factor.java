import java.util.Scanner;
public class Factor{
    public void factor(){
	  int x=Integer.parseInt(new Scanner(System.in).next());
	  int y=x;
	  y--;
	  while(y>0){
	     x*=y;
	     y--;
	  }
	  System.out.println("The factor of x is "+x);
	}

    
    public static void main(String[] args){
	  Factor factor=new Factor();
	  factor.factor();
	
	}






}
