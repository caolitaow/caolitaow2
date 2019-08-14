package advanced;

enum MyLock{
    lock1, lock2;
}

class MyThread1 extends Thread{
    int i = 0;
    @Override
    public void run() {
        while (true) {

            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MyLock.lock1) {
                i++;
                System.out.println("这是锁对象1--"+i);
                if(i == 10) break;

            }

            synchronized (MyLock.lock2) {
                System.out.println("这是锁对象2--"+i);
                try {
                    MyLock.lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("这是普通代码块--"+i);
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
