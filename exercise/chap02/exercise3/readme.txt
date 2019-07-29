已知类MyPoint表示一个二维的点，其定义如下：
public class MyPoint {
  public int x;
  public int y;

  public String toString() {
    return ("[" + x + "," + y + "]");
  }
}

使用上面已提供的MyPoint类，建立一个TestMyPoint程序，该程序执行下列操作：
1、定义两个类型为MyPoint的变量，变量名为：start 和 end。每个变量赋值一个新的MyPoint的对象。
2、将start 的 x 和 y 值设置为10，end的 x值设置为20，y值为30。
3、打印输出这两点变量，使用类似于如下的代码：System.out.println(“Start point is ”+start);
4、编译运行TestMyPoint。
5、声明一个类型为MyPoint的新变量，名为stray 将现有变量end 的引用值赋值给stray。
6、打印输出stray 和 end 。
7、将新值赋值给stray 变量的 x 和 y成员。打印输出stray end start。
8、编译运行TestMyPoint。end报告的值反映了stray中的变化，说明这两个变量引用的似同一个MyPoint对象。但是，start并没有改变，说明start与另两个变量无关。

输出结果应与下面类似：
Start point is 【10，10】
End point is 【20，30】
  
Stray point is 【20，30】
End point is 【20，30】
 
Stray point is 【47，50】	
End point is 【47，50】
Start point is 【10，10】
