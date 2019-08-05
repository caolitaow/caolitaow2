package clt.study;

import java.util.ArrayList;

//可以把Class与Student串起来用
class Class {
    String classname;
    int sum;
    int average;

    public void sumAverage(ArrayList<Student> list){
        int sum6 = 0;
        int sum7 = 0;
        int count6 = 0;
        int count7 = 0;
        int average6 = 0;
        int average7 = 0;
        for (Student s:
                list) {
            s.exam();
            if(s.classname.equals("6班")){
                count6++;
                sum6 += s.grade;
            }else{
                count7++;
                sum7 +=s.grade;
            }
        }
        average6 = sum6/count6;
        average7 = sum7/count7;

        System.out.println("7班总分与平均分："+sum7+"  "+average7+"\n"+
                "6班总分与平均分："+sum6+"  "+average6);
    }



}


public class Student {
    String name;
    String classname;
    int grade;
    static ArrayList<Student> list = new ArrayList<>();
    Student(String name, String classname){
        this.classname = classname;
        this.name = name;
    }

    public void exam(){
        grade = (int)(Math.random()*100+20);

    }


    public static void main(String[] args) {
        Class cl = new Class();
        list.add(new Student("卡卡西","7班"));
        list.add(new Student("佐助","7班"));
        list.add(new Student("鸣人","7班"));
        list.add(new Student("张三","6班"));
        list.add(new Student("李四","6班"));

        cl.sumAverage(list);

    }

}
