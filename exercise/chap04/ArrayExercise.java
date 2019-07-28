import java.util.*;
public class ArrayExercise{
    
	int[] array;
	String s1;
	int[][] twoD=new int[4][];
	ArrayExercise(){
		array=new int[]{12,35,45,13,64,55,88,77};
		s1="高温酷暑，上蒸下煮，男生出门，马上变成暖男，女生出门，妆容很难保全";
	}

	public void reversalArray(){
		int i,t=0;
		for(i=0;i<(array.length)/2;i++){
			t=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=t;
		}
		for(i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();	
	}

	public void charIndex(char value){
		char[] s=s1.toCharArray();
		System.out.println("你要找的字符在以下位置");
		for(int i=0;i<s.length;i++){
			if(value==s[i]){
				System.out.print(i+1+" ");
			}
		}
		System.out.println();
	}
	
	ArrayExercise(int h){
		//int j=0;
		int[] D0=new int[4];
		int[] D1=new int[5];
		int[] D2=new int[6];
		int[] D3=new int[7];
		twoD[0]=D0;
		twoD[1]=D1;
		twoD[2]=D2;
		twoD[3]=D3;
		print();
	}
	
	public void print(){
		for(int i=0;i<4;i++){
			for(int j=0;j<twoD[i].length;j++){
				System.out.print(twoD[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void random2D(){
		for(int i=0;i<4;i++){
			for(int j=0;j<twoD[i].length;j++){
				twoD[i][j]=(int)(Math.random()*100);
			}
		
		}
		print();
	
	}

	public void array1to2(){
		int[] oneD=new int[4];
		twoD[0]=oneD;
		oneD[0]=9;
		oneD[1]=8;
		for(int i=0;i<4;i++){
			System.out.print(oneD[i]+" ");
		}
		System.out.println();
		print();
	}

	public static void main(String[] args){
		ArrayExercise exercise=new ArrayExercise();
		exercise.reversalArray();
		exercise.charIndex('生');
		ArrayExercise exercise1=new ArrayExercise(8);
		exercise1.random2D();
		exercise1.array1to2();
	}


}
