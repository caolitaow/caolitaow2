package clt.study;

public abstract class Animal{
    protected  int legs;
    Animal(){

    }
    protected Animal(int legs){
        this.legs = legs;
    }

    public void eat(){
        System.out.println("动物在吃");
    }

    public void walk(){
        System.out.println("动物在走");

    }

    public void play(){
        System.out.println("动物在玩");
    }

}

//继承抽象类时，抽象类中必须要有无参构造器



