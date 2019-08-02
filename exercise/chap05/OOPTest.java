package clt.study;
import static java.lang.System.out;
import java.io.PrintStream;
interface staticTest {
    static int i = 0;

    public void test();

}

interface staticTest1 extends staticTest{
    public void test1();

}



 class Abstract extends abstractTest implements staticTest1{
    //final int i = 0;

     @Override
     public void test() {

     }

     @Override
     public void test1() {

     }

     @Override

    public void sfi() {
        super.sfi();
    }

    @Override
    public void sfi1() {

    }
}


class Static1 implements staticTest1,staticTest{
    @Override
    public void test() {

    }

    @Override
    public void test1() {

    }
}

abstract class  abstractTest extends OOPTest{
    static int i = 0;
    public void sfi(){};
    abstract public  void sfi1();

}

abstract class abstractTest1 extends   abstractTest{

}

 abstract class  c{
    static void h(){};

     public static void main(String[] args) {

     }
   // void ff();抽象类中的方法要不是抽象方法，要不就是已经实现了的方法
}
public class OOPTest {
    static public int i = 9;
    public int j = 9;
    public  void staticTest(){

    }

     class OOPtest{
        OOPTest t = new OOPTest();
        int j1 = j;
        //OOPTest.i;
    }
    public static void main(String[] args) {

        //OSon son = new OSon();

        OFather father = new OFather("1314520","鞠婧祎",22);
        OSon son = new OSon(800000);

        son.setId("2016110701");
        System.out.println(son.getId());

        System.out.println(son);
        System.out.println(father.getId());
        son.study();
        father = new OSon();
        OFather father1 = new OFather();
        father.character();
        father1.character();

        out.println("静态导入，直接调用");
      /*  PrintStream output = null;
        output.println("定义out的是PrintStream类，导入之后自己定义一个PrintStream对象输出");
*/
    }
}
