import java.util.Scanner;
public class GcdLcm{
    int x,y;
	GcdLcm(){
         x=Integer.parseInt(new Scanner(System.in).next());	
         y=Integer.parseInt(new Scanner(System.in).next());	
	}
	public int Gcd(){

        int x=this.x;
		int y=this.y;
		 int r=1,t=1;
		 r=x%y;
         if(r!=0){
          while(t!=0){
			 t=y%r;
             y=r;
			 r=t;  
		 }
        return y; 
	  }else return y;
       
	
	}
	public int Lcm(){
	   int x=this.x;
	   int y=this.y;
	   return x*y/Gcd();
	   
	
	}
	public static void main(String[] args){
	   
		GcdLcm gcdlcm=new GcdLcm();
		System.out.println("最大公约数为"+gcdlcm.Gcd());
		System.out.println("最小公倍数为"+gcdlcm.Lcm());
	}

}
