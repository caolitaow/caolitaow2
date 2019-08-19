package advanced;

/**
 * 两个线程. 一个线程对变量i加一. 另一个线程对变量i减去一.两线程顺序执行,
 * 每个线程都将所有的同步代码块执行完了，打印结果0 1 2 1 0 1 2 1 0 1 2...[/b]
 */
class Runnablex implements Runnable{
    static int i,j;
    boolean flag = true;

    void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        //先加后减
        while (true){
            synchronized (this){
               System.out.println(i++);
               sleep();
               this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (this){
                System.out.println(i--);
                sleep();
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

public class ThreadHomework2_Run2 {
    public static void main(String[] args) {
        Runnablex rux = new Runnablex();
        new Thread(rux,"线程2").start();
        new Thread(rux,"线程1").start();

    }
}
