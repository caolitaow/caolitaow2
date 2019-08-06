package advanced;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    List list = new ArrayList();

    public Test1() {
        list.add("seo");
        list.add(new Teacher(2,9));
        list.add(1);
    }

    public  void printList(){
        for (Object o:
             list) {
            String s = (String)o;//编译时没有报错，但运行时强转成String类型
            System.out.println(s);//是以实际类型转的而不是父类型（Object）
            //所以出现类型强转异常


        }


    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.printList();
    }

}

