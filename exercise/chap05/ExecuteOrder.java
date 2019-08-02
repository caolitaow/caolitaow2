package clt.study;


class C1{



   {
      // System.out.println("所有属性的值: "+this.i+" "+this.j+" "+is+" "+js);
        i = 1;
        j = 1;
        is = 100;
        js = 200;
        //C1 c2 = new C1();
        System.out.println("所有属性的值: "+this.i+" "+this.j+" "+is+" "+js);
        //注意上面的i之所以要加上this，是因为其属于println()形参的一部分，即可以看作是println()方法中的局部变量，
       // 因此要指定该i是属于哪个对象的i
    }

    int i = 0;
    int j;
    //C1 c = new C1();
    static int is = 10;
    static int js;



   /* C1(){
        System.out.println("所有属性的值: "+i+" "+j+" "+is+" "+js);
    }*/

}



public class ExecuteOrder {

    public static void main(String[] args){
       new C1();
    }
}


