package advanced;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Worker {
    private int workerId;
    private String name;
    private int age;
    private static List list;

    static {
        try {
            list = (ArrayList) new ReflectList().ReflectList();
        } catch (Exception e) {
            System.out.println("反射List集合失败！");
        }
    }

    private static int count;
    public Scanner scan = new Scanner(System.in);
    public Worker() {
         count++;
         workerId = count;
         name = scan.next();
         age  = scan.nextInt();
    }

    @Override
    public String toString() {
        return "工人"+ workerId+"{"+
                "name= " + name +
                ", age=" + age +
                "}";
    }
}


public class Reflect {

    List list;
    ReflectList reflectList = new ReflectList();

    {
        try {
            list = (ArrayList)reflectList.ReflectList();
        } catch (Exception e) {
            System.out.println("反射List集合失败！"); 
        }
    }

    Class<?> w;

    public void reflectOpWorker(int workernums) throws Exception{
        int i = 0;
        while (i < workernums){
            Object o = w.newInstance();
            reflectList.add1(o);
            i++;
        }
    }

    public void reflectOpList() throws Exception{
       Field field = w.getDeclaredField("list");
       field.setAccessible(true);
       field.set(null,list);
        for (Object ob:
            (ArrayList)field.get(null)) {
             System.out.println(ob);
        }
    }

    public Reflect(String str) throws ClassNotFoundException {
        w = Class.forName(str);
    }

    public static void main(String[] args) throws Exception{
        Reflect reflect = new Reflect("advanced.Worker");
        reflect.reflectOpWorker(4);
        reflect.reflectOpList();
    }
}

//反射List集合类产生镜像，用镜像完成相应操作
class  ReflectList<E>{

    Class<?> rlist;
    Object o;

    ReflectList(){}

    public Object ReflectList() throws Exception{
       rlist = Class.forName("java.util.ArrayList");
       o = rlist.newInstance();
       return o;
    }

    public void add1(E e) throws Exception{
        Method method = rlist.getDeclaredMethod("add",Object.class);
        method.invoke(o,e);
    }

}



