/*
 *此类是用三目运算符来比较两个数的大小
 *
 **/
import java.util.Scanner;

public class TernaryOperator{
	//获取最大值
    int max;

    //获取最小值
	int min;
    
    //若为最大值则status等于true,否则等于false
    boolean status;

    //此数组用于存用户输入的数值
	int[] numbers;

	//初始化数组
	TernaryOperator(){
		int size;
		int i = 0;
		System.out.println("Please enter the size of the array:");
        size = Integer.parseInt(new Scanner(System.in).next());
		numbers = new int[size];
		while(i < size){
			numbers[i] = Integer.parseInt(new Scanner(System.in).next());
			i++;
		}
	}

	//判断status的值输出相应内容
	public void print(boolean status){
	    if(status){
			System.out.println("The value of the biggest is "+max);
		}else
			System.out.println("The value of the minimum is "+min);
	}

	//用三目运算符获取一组数中的最大值与最小值
	public void compare(){
		int bigger = numbers[0];
		int smaller = bigger;
		/*int bigger = x > y ? x : y;
		max = bigger > z ? bigger : z;
		status = true;
		print(status);*/
		for(int i = 1;i < numbers.length;i++){
			bigger = bigger > numbers[i] ? bigger : numbers[i];
			smaller = smaller < numbers[i] ? smaller : numbers[i];
		}
		max = bigger;
		status = true;
		print(status);
		min = smaller;
		print(!status);
	}

	public static void main(String[] args){
		TernaryOperator t = new TernaryOperator();
		t.compare();
   }

}
