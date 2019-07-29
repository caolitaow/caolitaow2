/**
 *巩固类型转换相关知识
 *
 *
 */

public class TypeCast{
	byte a = 30;
	byte b = 21;
	byte c = (byte)130;
	byte sumb;
	int sumi;
	
	public void cast(){
		/*
		sumb = a / b;
		sumb = a * b;
		sumb = a + b;*/
		//四则运算符会将byte类型运算的结果转换为int型
		/*
		sumb = 3.0 + 3;
		sumb = 3f + 3.0;
		sumb = 3l + 3.0;//long类型与double型运算时结果是double型*/
		/*整数在内存中都是以二进制补码的形式运算与存储的
		 *即先将整数转换成原码，进而变成补码参与运算后，保存为声明的类型，再将其转换成原码，以十进制形式显示给用户
		 */		
		System.out.println("The overflow!"+c);
		sumb = (byte)(a + b);
		//直接输出变量,一般以十进制形式输出	
		System.out.println("bin:"+Integer.toBinaryString(sumb)+"\n"+"Dec:"+(int)sumb);
		sumb = (byte)(3f + 3.0);
		System.out.println(sumb);
		sumi = 3 + 4;
		System.out.println("Type Cast!");
	}

	public static void main(String[] args){
		TypeCast cast = new TypeCast();
		cast.cast();
	}


}

