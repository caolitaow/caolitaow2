
package com.personal.code1;
public class Sort{
	static void sort1(int [] sequ){
		int i,j,t,r;
		for(i=0;i<4;i++){
			r=i;
			
			for(j=i+1;j<5;j++){
				if(sequ[j]<sequ[i])
					i=j;
			}
			if(r!=i){
				t=sequ[r];
				sequ[r]=sequ[i];
				sequ[i]=t;
			
			}
			i=r;

		}
		for(i=0;i<5;i++){
			System.out.print(sequ[i]);
		}
        System.out.println("Sorting success!");	
	}
	
	public static void main(String[] args){
		int [] sequ={4,7,1,9,0};
		sort1(sequ);
		
	}
}
