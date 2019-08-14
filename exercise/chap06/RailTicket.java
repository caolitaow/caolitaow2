package advanced;

/**
 * 火车站售票---线程安全问题（线程同步解决）
 * 三个窗口同时售卖火车票和高铁票
 */
class TicketWindows implements Runnable{
    private int trainTickets = 100;
    private int highSpeedTickets = 100;
    Lock lock = new Lock();

    //同步方法
    public synchronized void highSpeedTicket(){

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售" + highSpeedTickets-- + "号高铁票");

    }
    @Override
    public void run() {
        //synchronized (lock){//锁加在这，只允许一个线程（窗口）卖票了，等下个线程拿到锁执行时，一看tickets=0
            //故就不执行了
            while (true){
            //1s售一张票?为啥会重复售票
            //两个线程几乎同时进入循环当第一个线程卖了第100张时，还没来得及减减成99张票时，第二个线程
            //又来卖票，又将第100张票卖出去了，即重复卖了同一张票；通过加锁，每次只能让一个线程卖票，
            //等一个线程卖完，后面一个线程才能对公共资源（票）进行操作

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //同步代码块
                //设是窗口2卖完了最后一张火车票，当窗口2执行到break时，它还有其他两个窗口就已经抢到了执行同步方法
                //highSpeedTicket()所需的锁对象ticketWindows，故虽然窗口2在前面已经跳出了该循环，但也在卖高铁票了
                synchronized (lock){
                    //System.out.println(Thread.currentThread().getName());
                    //锁里面保证是一个线程，一个线程执行代码的时候有先后顺序
                    if (trainTickets == 90)break;
                    System.out.println(Thread.currentThread().getName()+"正在售"+trainTickets--+"号火车票");

                    //if(highSpeedTickets == 0)break;//这样的话，当火车票卖到第91号后，该窗口和其他窗口不再售卖高铁票和火车票
                   //highSpeedTicket();//线程隔1s出售一张票
                }

                if(highSpeedTickets == 0)break;
                highSpeedTicket();
            }

        //}
    }
}



public class RailTicket {
    public static void main(String[] args) {
        TicketWindows ticketWindows = new TicketWindows();
        new Thread(ticketWindows,"窗口1").start();
        new Thread(ticketWindows,"窗口2").start();
        new Thread(ticketWindows,"窗口3").start();

    }
}

class Lock{}

