package advanced;

import java.util.HashMap;
import java.util.Map;

class HwRun implements Runnable {
    int j = 1;
    boolean flag = true;
    Map<Integer, Character> map = new HashMap<>();

    HwRun() {
        char c = 'A';
        int i = 1;
        while (i < 53) {
            if (c > 'Z') c = 'A';
            map.put(i++, c++);
        }
    }

    void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (j < 53) {
            synchronized (this) {
                i = j;
                System.out.print(String.valueOf(j++));
                sleep();
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (this) {
                if (!flag){
                    try {
                        flag = true;
                        this.notify();
                        this.wait();
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(map.get(i)+"-------"+Thread.currentThread().getName());
                sleep();
                flag = false;
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

class ThreadHomework1{

    public static void main(String[] args) {
        HwRun hwRun = new HwRun();
        new Thread(hwRun).start();
        new Thread(hwRun).start();
    }

}
enum HomewLock{
    hk1,hk2
}
