package  advanced;

import java.util.Random;

/**
 * 两个线程依次抽奖
 */
public class ThreadHomework3{
    public static void main(String[] args) {
        LotteryRun lottery = new LotteryRun();
        new Thread(lottery, "抽奖箱1").start();
        new Thread(lottery, "抽奖箱2").start();
    }
}

class LotteryRun implements Runnable{
    int flag;
    int[] arr={10,5,20,50,100,200,500,800,2,80,300};
    Random random = new Random();
    @Override
    public void run() {
        while (true){
            synchronized (this){
                flag++;
                if (flag==1 && Thread.currentThread().getName().equals("抽奖箱2")){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"恭喜你获得奖金："+
                        arr[random.nextInt(arr.length)]+"元");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}