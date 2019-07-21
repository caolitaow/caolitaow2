public class MultiTable{
    public void multiTable(){
	   int i,j,t=0;
	   int x;
	   for(i=9;i>0;i--){
	      for(j=0;j<9-i;j++){
		      System.out.print("      "+"  ");
		  }
		  for(t=0,x=1;t<i&x<=i;t++){
		      System.out.print(x+"x"+i+"="); 
			  if((x*i)<10){
			//	  System.out.print(' ');
				  System.out.print(" "+(x*i)+"  ");
			  }
			  else System.out.print((x*i)+"  ");
			  x++;
			}
		  System.out.println();
		  }
	   
	   }
	
	


    public static void main(String[] args){
		MultiTable table=new MultiTable();
		table.multiTable();
	
	}

}
