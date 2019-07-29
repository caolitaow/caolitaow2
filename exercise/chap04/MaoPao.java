
public class MaoPao{

    public static void maopao(int[] a){
	   int i,j,t=0;
	   for(i=0;i<5;i++){
		for(j=0;j+1<6;j++){
			if(a[j]>a[j+1]){
			  t=a[j];
			  a[j]=a[j+1];
			  a[j+1]=t;
			}
		}
	   
	   }
	   for(i=0;i<6;i++){
	   
	    System.out.print(a[i]);
	   }
	
	}
    
	public static void luckNum(String[] a){
		int index=(int)(Math.random()*3);
		System.out.println(a[index]);
	
	}
	
	public static void yzm4(){
		String s="abcdefghijklmnopqrstuvwxyz0123456789";
		char[] a=s.toCharArray();
	    int i=0;
		while(i<4){
		  System.out.print(a[(int)(Math.random()*36)]);
		  i++;
		}
		
	}
	public static void main(String[] args){
	    String[] a1={"1123","234","344"};
		int[] a={100,34,56,12,78,10};
		//maopao(a);
		//luckNum(a1);
		yzm4();
	}

}
