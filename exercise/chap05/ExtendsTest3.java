//看程序写结果
class X {
     //成员变量(引用类型)
     Y b = new Y();
     //无参构造方法
     X() {
         System.out.print("X");
     }
 }
 
 class Y {
     //无参构造方法
     Y() {
         System.out.print("Y");
     }
 }
 
 public class ExtendsTest3 extends X {
     //成员变量(引用类型)
     Y y = new Y();
     //无参构造方法
     ExtendsTest3() {
         //super(); //它仅仅表示要先初始化父类数据，再初始化子类数据。
         System.out.print("Z");
     }
     public static void main(String[] args) {
         new ExtendsTest3(); 
     }
 }