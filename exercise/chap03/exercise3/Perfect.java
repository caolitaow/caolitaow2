import java.util.Scanner;
public class Perfect{
    int x;
	Perfect(){
	  x=Integer.parseInt(new Scanner(System.in).next());
	}
	public void perfect(){
	   int x=this.x;
	   int sum;
	   int i=1;int j;
	   System.out.println("你指定的范围内的完全数有：");
	   while(i<x){
        sum=0;
		for(j=1;j<(i/2)+1;j++){
	     if(i%j==0){
		    sum+=j;
		 }

	   }
	   if(sum==i)
	   System.out.println(sum);
	   i++;
	   
	}
  }
    public static void main(String[] args){
	  Perfect perfect=new Perfect();
	  perfect.perfect();
	
	}




} 
