package advanced;

//注意泛型类指的是类中参数是泛型，写在类名后
class SS<T> {
    T a;

    /*<R> void  show(T t){
        return ;
    }*/

    public T clt1(T t){
        System.out.println(t);
        return null;
    }

    //静态方法不能直接使用泛型参数，必须先把自己定义成泛型方法
    static <T> void  clt2(T t){

    }

    static <Q> void  clt(Q q){
        System.out.println(q);
       // return;
    }
}

public class Test3 {

    public static void main(String[] args) {
        SS<String> s = new SS<String>();
        s.clt(" s ");
       // s.clt1("");
        s.clt(new Teacher(2,9));
        SS.clt2(" ");//为什么指定泛型调用不行；因为类指定泛型了，那静态方法属于类（但静态方法的泛型参数可以不确定）
        //那可以理解成静态方法的泛型参数要与类的一致，这就与静态方法的泛型参数可以不确定这个事实矛盾了
        //所以不能指定，让Object类（没有指定泛型的类）去调用不确定泛型参数的静态方法
        SS.clt(new Teacher(2,9));
    }

}

