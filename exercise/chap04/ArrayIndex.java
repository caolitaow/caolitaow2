public class ArrayIndex{
    
	int array1[];
	ArrayIndex(int[] array){
	   array1=new int[8];
       this.array1=array;
	
	
	}

	public void ArrayOperate(){
	   int array2[]=this.array1;
	   int i;
	   for(i=0;i<4;i++){
		   array2[i*2]=2*i;
	   }
	   for(i=0;i<8;i++){
	      System.out.print(array1[i]+"  ");
	   }
	   
	}



	public static void main(String[] args){
	    int[] array1={2,3,5,7,11,13,17,19};
		ArrayIndex index=new ArrayIndex(array1);
	    index.ArrayOperate();
	}




}
