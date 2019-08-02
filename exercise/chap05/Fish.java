package clt.study;

public class Fish extends Animal implements Pet{
    public Fish(){

    }
    public void play(){
        System.out.println("鱼在玩");
    }

    public void walk(){
        System.out.println("鱼在游");
    }

    public void eat(){
        System.out.println("鱼在吃");
    }
}
