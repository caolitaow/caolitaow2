package advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

 enum Run4{
     runkey;
    static int i = 0;
    static boolean flag = false;
    static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AddRunnable implements Runnable {
    int flag = 0;
    @Override
    public void run() {
        while (true){
            synchronized (Run4.runkey){
               /* flag++;
                if (Thread.currentThread().getName().equals("线程2")&&flag%2==1){
                    try {
                        Run4.runkey.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (Run4.flag){
                    try {
                        Run4.runkey.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-----"+Run4.i++);
                Run4.sleep();
                if (Run4.i==2){
                    Run4.flag = true;
                    Run4.runkey.notifyAll();
                }
                try {
                    Run4.runkey.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

class SubRunnable implements Runnable {
     int flag = 0;
    @Override
    public void run() {
        while (true){
            synchronized (Run4.runkey){
               /* flag++;
                if (Thread.currentThread().getName().equals("线程4")&&flag%2==1){
                    try {
                        Run4.runkey.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (!Run4.flag){
                    try {
                        Run4.runkey.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-----"+Run4.i--);

                Run4.sleep();
                if (Run4.i==0){
                    Run4.flag = false;
                    Run4.runkey.notifyAll();
                }
                try {
                   Run4.runkey.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadHomework2_Run4 {
    public static void main(String[] args) {
        //若上面用this做锁对象，就会有两种不同的所对象
        AddRunnable addRun = new AddRunnable();
        SubRunnable subRun = new SubRunnable();
        new Thread(addRun,"线程1").start();
        new Thread(addRun,"线程2").start();
        new Thread(subRun,"线程3").start();
        new Thread(subRun,"线程4").start();


    }

}

class SwitchLock{

}
