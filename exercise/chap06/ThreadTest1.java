package advanced;

/**
 * 测试Object类中有关线程的方法
 */
class Thread1 extends Thread{
    int i = 100;
    Thread thread = Thread.currentThread();//与下相同
    @Override
    public void run() {
        synchronized (Locks.key1) {
            while (i > 0) {

                if (i == 90) {
                    new Thread(new Runnable1(), "Run线程").start();
                    System.out.println(thread + "----" + this.getName() + ":::" + i--);
                } else {
                    System.out.println(thread + "----" + this.getName() + ":::" + i--);
                }

            }
        }

    }
}

class Runnable1 implements Runnable{
    int i = 100;
    Thread thread = Thread.currentThread();//这里的线程对象与执行run()方法的线程对象不同
    @Override
    public void run() {
        synchronized (Locks.key2) {
            while (i > 0) {
                if (i == 99) {
                     thread.stop();//这是直接关闭线程
                    try {
                        Locks.key2.wait();//可以看作这是直接"关闭"同步代码块等待唤醒，Lock.key1.wait()不能在一个代码块里
                        //调用另一个锁对象里的有关线程的方法

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   /* try {
                        Locks.key1.wait();//怎么让上面的线程进入阻塞而不是死亡
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
                System.out.println(thread + "----" + Thread.currentThread().getName() + ":::" + i--);
                //System.out.println(thread.getThreadGroup());
            }
        }

    }
}


public class ThreadTest1 {
   // static Tests tests = new Tests();
    public static void main(String[] args) {
        new Thread1().start();
        //new Thread(new Runnable1(),"Run线程").start();
    }

}

enum Locks {
    key1,key2

}
