import java.util.*;
public class Insertion{
	int[] num;
	
	Insertion(int size){
		num=new int[size];
	    for(int i=0;i<size;i++){
		  num[i]=Integer.parseInt(new Scanner(System.in).next());
		}
	
	}
	
	
	public void insertSort(){
		int i,j,r,t;
		for(i=0;i<num.length;i++){
		  r=i;
		  for(j=i-1;j>=0;j--){
		     if(num[i]<num[j]){
			   t=num[i];
			   num[i]=num[j];
			   num[j]=t;
			   i=j;
			 }	
		  }
		  i=r;
		
		}
		System.out.print("从小到大的顺序为：");
		for(i=0;i<num.length;i++){
			System.out.print(num[i]+"  ");
		
		}
	
	}
	
	public static void main(String[] args){
		Insertion insert=new Insertion(5);
		long start=System.currentTimeMillis();
		insert.insertSort();
        System.out.println();
	    long end=System.currentTimeMillis();
		System.out.println(end-start);
	}



}
