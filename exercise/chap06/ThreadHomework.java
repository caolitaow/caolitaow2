package advanced;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;

/**
 * 通过第三方类的资源或者将Thread类的子实现类的资源静态化，可以避免多线程的安全问题
 * 不过这样的话，共享资源（数据）生命周期较长
 * bug：可能会输出5354null,或者1234A最后会多输出一个字母
 */

class CltThread1 extends Thread{
    public CltThread1(String name) {
        super(name);
    }
    public void run() {
        while (true) {
            synchronized (SLock.lock1){
                if(!Comm.flag){
                    try {
                        SLock.lock1.notify();
                        SLock.lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Comm.sleep();
                Comm.bx = Comm.bx.add(Comm.i);
                System.out.println(this.getName()+"---"+Comm.bx.doubleValue());
                Comm.flag = false;
            }
        }
    }
}

class CltThread2 extends Thread{
    public CltThread2(String name) {
        super(name);
    }

    public void run() {
        while (true) {
            synchronized (SLock.lock1){
                if (Comm.flag) {
                    try {
                        SLock.lock1.notify();
                        SLock.lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Comm.sleep();
                Comm.bx = Comm.bx.add(Comm.j);
                System.out.println(this.getName()+"---"+Comm.bx.doubleValue());
                Comm.flag = true;
            }

        }
    }
}

class Comm{
    static boolean flag = true;
    static BigDecimal bx = new BigDecimal(Double.toString(0));
    static BigDecimal i = new BigDecimal(Double.toString(1.0));
    static BigDecimal j = new BigDecimal(Double.toString(0.1));
    static void sleep(){
        if(Thread.currentThread().getName().equals("线程1"))
        try {
           Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }else try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadHomework {

    public static void main(String[] args) {
       new CltThread1("线程1").start();
       new CltThread2("线程2").start();
    }
}
enum  SLock{
    lock1
}

