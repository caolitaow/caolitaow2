//������д���
class X {
     //��Ա����(��������)
     Y b = new Y();
     //�޲ι��췽��
     X() {
         System.out.print("X");
     }
 }
 
 class Y {
     //�޲ι��췽��
     Y() {
         System.out.print("Y");
     }
 }
 
 public class ExtendsTest3 extends X {
     //��Ա����(��������)
     Y y = new Y();
     //�޲ι��췽��
     ExtendsTest3() {
         //super(); //��������ʾҪ�ȳ�ʼ���������ݣ��ٳ�ʼ���������ݡ�
         System.out.print("Z");
     }
     public static void main(String[] args) {
         new ExtendsTest3(); 
     }
 }