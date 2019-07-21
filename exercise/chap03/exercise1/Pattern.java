public class Pattern{
   public void print(int i,int j){
       int x=0;
	   while(x<(13-i-j)/2){
	     System.out.print(' ');
         x++;	   
	   }
   
   }

   public void ladder(){
	  int i,j;
	  for(i=0;i<7;i++){
		for(j=0;j<6-i;j++){
			System.out.print(' ');
		
		}
		while(j<7){
			System.out.print('*');
			j++;
		}
	    System.out.println();
	  }
   
   }
   public void triangle(){
	   int i,j,t;
      
	    for(j=1,i=0;j<=7&i<7;i++,j++){
			t=0;
			print(i,j);
			while(t<j+i){
	          	System.out.print('*');
				t++;
			}
		    print(i,j);
			System.out.println();
		}
   }
  public static void main(String[] args){
	  Pattern p=new Pattern();
	  p.ladder();
	  p.triangle();  
  
  }


}
