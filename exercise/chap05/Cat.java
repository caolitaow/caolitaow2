package clt.study;

public class Cat extends Animal implements Pet {
    public Cat(String name){

    }

    public Cat(){

    }

    public void play(){
        System.out.println("猫在玩");
    }

    public void walk(){
        System.out.println("猫在走");
    }

    public void eat(){
        System.out.println("猫在吃");
    }
}
