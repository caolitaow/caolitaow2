import java.util.Scanner;
public class BubbleSort{
	int num[];
	BubbleSort(int size){
	    num=new int[size];
		for(int i=0;i<size;i++){
			num[i]=Integer.parseInt(new Scanner(System.in).next());
		}
	
	}
	public void bubble(){
	  int i,j,t=0;
	  for(i=0;i<num.length-1;i++){
		for(j=0;j+1<num.length;j++){
			if(num[j]>num[j+1])
			{
			   t=num[j];
			   num[j]=num[j+1];
			   num[j+1]=t;
			}
		}
	  
	  }
	  System.out.print("从小到大的顺序为：");
	  for(i=0;i<num.length;i++){
		System.out.print(num[i]+"  ");
	  }
	}
	public int[] Arraysize(){
	    int[] num={3,8,1,2,9};
		return null;
	}
	
	public static void main(String[] args){
	    
		BubbleSort sort=new BubbleSort(5);
		
		sort.bubble();
	
	}



}
