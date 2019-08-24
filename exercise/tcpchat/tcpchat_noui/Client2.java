package advanced.tcpchat.tcpchat_noui;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Client2{


    //空字符串用于接受用户的消息
    public static String recivemessage="";
    static String sendmessage="";
    static ServerSocket c1;
    static byte[] bytes = new byte[1024];
    static Date date;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //static Socket c2_1;

   /* static {
        try {
            c2_1 = new Socket("127.0.0.1",7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    static int i = 0;
    static {
        try {
            c1 = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Socket c2;

    static {
        try {
            c2 = c1.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //static Scanner scanner = new Scanner(System.in);


    public static void sendMessage() throws IOException {
        OutputStream os = c2.getOutputStream();
        BufferedOutputStream bo= new BufferedOutputStream(os);
        //BufferedOutputStream bo = new BufferedOutputStream(os);
        //System.out.println("服务端: ");
        sendmessage = Client2Ui.messageSend;

        if (MeChat.flag2){
            return;
        }
        bo.write(sendmessage.getBytes());
        bo.flush();
        MeChat.flag2 = true;
        //reiveMessage();//接着接收消息，如果对方不发消息则接收不到消息，但自己依然可以继续发消息


        //流等资源等到聊天结束了才关闭

    }

    public static void reciveMessage() throws IOException {

        InputStream is = c2.getInputStream();
        BufferedInputStream bi = new BufferedInputStream(is);
        // BufferedInputStream bi = new BufferedInputStream(is);
         bi.read(bytes);
        date = new Date();
        recivemessage = new String(bytes);//收到的消息

       // System.out.println("客户端的内容呢"+"0000");//拼接上recivemessage跟它拼接的字符串就消失了？
        System.out.println("客户端："+recivemessage);//显示在控制台上给用户看
        Client2Ui.textArea1.append(dateFormat.format(date)+"\n");
        Client2Ui.textArea1.append(Client2.recivemessage);
        Client2Ui.textArea1.append("\n"+"\n");

       // MyChatUI.myChatUI.reciveMessage.append(recivemessage);
       for (int i = 0;i<1024;i++){
           bytes[i] = 0;
       }
        //MeChat1.meChat1.message = message;
        //System.out.println(MeChat1.message);

    }

    public static void main(String[] args) {
        new SendThread1().start();
        new ReciveThread1().start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client2Ui().setVisible(true);
            }
        });
        //System.out.println("main:"+Client2.recivemessage);
    }
}

class SendThread1 extends Thread{

    @Override
    public void run() {

        while (true) {
            //synchronized (Chat.chat1){
              //  if (Chat.flag1){
                  //  System.out.println("服务端发送线程睡着了");
                   /* try {
                        Chat.chat1.wait(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    //Chat.flag1 = false;
                  //  continue;
                //}
                    try {
                       Client2.sendMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Chat.flag1 = true;
                    //Chat.chat1.notify();//唤醒对方接收消息


            }

       // }
    }
}

class ReciveThread1 extends Thread{

    @Override
    public void run() {
        while (true){
          //  synchronized (Chat.chat2){
            //    if (!Chat.flag2){
                    //System.out.println("服务端接收线程睡着了");
                 /*   try {
                        Chat.chat2.wait(500);//等待对方发消息，才被唤醒
                        //服务端接收线程5s后自动苏醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                   // System.out.println("服务端接收线程被唤醒");
                   // Chat.flag2 = true;
                    //continue;
                //}
                   //System.out.println("服务端接收线程开始工作");
                    try {
                      Client2.reciveMessage();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Chat.flag2 = false;
                   // Chat.chat2.notify();



            }

        }

    }





