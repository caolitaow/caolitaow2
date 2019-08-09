package advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

//测试枚举类；单例模式：懒汉模式，饿汉模式
enum Enum {
    e1, e2, e3, e4, e5,e6;//均是public static final修饰
    static int enumcount;
    int memoryaddress;

    public void show(){
        System.out.println("In show()");
    }

    public static void setPorperty(){
        enumcount = 3;
        System.out.println("此枚举类有"+enumcount+"个对象");
    }

    /*public static void setPorperty(int i){
        enumcount = 3;
        System.out.println("此枚举类有"+enumcount+"个对象");
    }*///静态方法之间，静态方法与实例方法之间均能重载

    public void setPorperty(Enum e){
        memoryaddress = e.hashCode();
       /* System.out.println(memoryaddress);//hashCode值
        System.out.println(e);*/
    }

    Enum(){

    }


}

//newInstance(Class里的创建任意对象的方法)
public class Test5 {
    static Map<Enum,Integer> enummap = new HashMap();


    public static void main(String[] args) {
        int memoryaddress;
        for (Enum e:
        Enum.values()) {
            e.setPorperty(e);
            enummap.put(e,e.memoryaddress);
        }
        for (Enum e:
             enummap.keySet()) {
            System.out.println(e+"="+enummap.get(e));
        }
    }
}
