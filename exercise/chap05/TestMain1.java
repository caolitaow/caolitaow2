package clt.study;
class Super{
    public static void m1(){
        System.out.println("m1 in Super");
    }
    public void m2(){
        System.out.println("m2 in Super");
    }
}
class Sub extends Super{

    public static void m1(){

        System.out.println("m1 in Sub");
    }
    public void m2(){
        //this.m1();
        super.m2();
        System.out.println("m2 in Sub");
    }
}
public class TestMain1{
    public static void main(String args[]){
       /* Super sup = new Sub();
        sup.m1();
        sup.m2();*/
       // Sub sub = (Sub) sup;
        Sub sub = new Sub();
        sub.m1();
        sub.m2();
    }
}

