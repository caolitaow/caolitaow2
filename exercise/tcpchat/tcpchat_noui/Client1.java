package advanced.tcpchat.tcpchat_noui;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 一个没有UI的基于TCP的聊天程序一对一聊天跟线程同步没有关系
 */

//客户端与【客户端】"服务端"共用资源
 class MeChat {
    public static boolean flag1 = false;
    public static boolean flag2 = false;
}



//客户端1作为TCP中的客户端
public class Client1{



    //空字符串用于接受用户的消息
    static String recivemessage="";
    static String sendmessage="";
    static Socket c1;
    static byte[] bytes = new byte[1024];
    static Date date;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //static ServerSocket c1_2;

    /*static {
        try {
            c1_2 = new ServerSocket(7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
   // static Socket c12;

    /*static {
        try {
            c12 = c1_2.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    static int i = 0;

    static {
        try {
            c1 = new Socket("127.0.0.1",6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //static Scanner scanner = new Scanner(System.in);
    public Client1() throws IOException {
       /* ip = "127.0.0.1";
        port = 9999;
        c1 = new Socket(ip,port);*/
    }

   /* public  void setIpandPort() throws IOException {
        this.ip = scanner.next();
        this.port = scanner.nextInt();//当输入的不是数字时会抛异常
        c1 = new Socket(ip,port);
    }
*/
    public static void sendMessage() throws IOException {
        //System.out.println(i);
        OutputStream os = c1.getOutputStream();
        BufferedOutputStream bo = new BufferedOutputStream(os);
        //System.out.println("客户端: ");
        sendmessage = Client1Ui.messageSend;
        if (MeChat.flag1){
            return;
        }
        System.out.println("客户端发送线程："+sendmessage);
        bo.write(sendmessage.getBytes());
        bo.flush();
        MeChat.flag1 = true;
        //i++;
       // scanner.next();//阻塞式方法，防止它一直写，导致另一端一直读
            //reciveMessage();//接着接收消息，如果对方不发消息则接收不到消息，但自己依然可以继续发消息


        //流等资源等到聊天结束了才关闭

    }

    //不能直接输回车换行？
    public static void reciveMessage() throws IOException {
        InputStream is = c1.getInputStream();

        BufferedInputStream bi = new BufferedInputStream(is);
        bi.read(bytes);
        recivemessage = new String(bytes);//收到的消息
       // System.out.println("下面的字符串跑哪去了？".length());
        //System.out.println(recivemessage.length());
        date = new Date();
        System.out.println("服务端："+recivemessage);//显示在控制台上给用户看
        Client1Ui.textArea1.append(dateFormat.format(date)+"\n");
        Client1Ui.textArea1.append(Client1.recivemessage);//为什换行放一起写就没有换行的作用？
        Client1Ui.textArea1.append("\n"+"\n");

        for (int i = 0;i<1024;i++){
            bytes[i] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        //new SendThread1().start();
        new SendThread().start();
       //new ReciveThread1().start();
        new ReciveThread().start();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client1Ui().setVisible(true);
            }
        });
    }
}

class SendThread extends Thread{


    @Override
    public void run() {

        while (true) {
           // synchronized (Chat.chat2){
               // if (Chat.flag2){
                  //  System.out.println("客户端发送线程睡着了");
                 /*   try {
                        Chat.chat2.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                  //  Chat.flag2 = false;
                 //   continue;
               // }
                    try {
                        Client1.sendMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Chat.flag2 = true;
                    //Chat.chat2.notify();//唤醒对方接收消息


            }

        }
    }
//}

class ReciveThread extends Thread{

    @Override
    public void run() {
        while (true){
            //既然不同线程组间的线程不能通信，那就读一次睡着一次，可为什么一开始只睡着了一次
           // synchronized (Chat.chat1){
                //if (!Chat.flag1){
                   // System.out.println("客户端接收线程睡着了");
                  /*  try {
                        Chat.chat1.wait(500);//这里释放的锁对象不可能会被另外一个线程组【另一个文件的main线程组】
                        //里的线程抢到
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                  //  System.out.println("客户端接收线程被唤醒");
                   // Chat.flag1 = true;//既然别的线程组里的线程抢不到这把钥匙，就自己玩
                  //  continue;
                //}
                    //System.out.println("客户端接收线程开始工作");
                    try {
                        Client1.reciveMessage();//在这阻塞了

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                   // Chat.flag1 = false;
                   // Chat.chat1.notify();


            }

        //}

    }
}




