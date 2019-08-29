package advanced.tcpchat;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * 一个没有UI的基于TCP的聊天程序一对一聊天跟线程同步没有关系
 */

//客户端1作为TCP中的客户端
public class Client1 extends MeChat{


    //空字符串用于接受用户的消息
    static String recivemessage="";
    static String sendmessage="";
    static Socket c1;
    static Date date;
    static Player player;
    //static ServerSocket c1_2;

    /*static {
        try {
            c1_2 = new ServerSocket(7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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


    public static void sendMessage() throws IOException {
        OutputStream os = c1.getOutputStream();
        BufferedOutputStream bo = new BufferedOutputStream(os);

        sendmessage = Client1Ui.messageSend;
        if (flag1){
            return;
        }
        bo.write(sendmessage.getBytes());
        bo.flush();
        flag1 = true;

    }

    public static void reciveMessage() throws IOException {
        FileInputStream fi = new FileInputStream(tone);
        BufferedInputStream bi1 = new BufferedInputStream(fi);
        InputStream is = c1.getInputStream();
        BufferedInputStream bi = new BufferedInputStream(is);
        bi.read(bytes);
        recivemessage = new String(bytes);//收到的消息

        try {
            player = new Player(bi1);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        date = new Date();
        System.out.println("服务端："+recivemessage);//显示在控制台上给用户看
        Client1Ui.textArea1.append(dateFormat.format(date)+"\n");
        Client1Ui.textArea1.append(Client1.recivemessage);//为什换行放一起写就没有换行的作用？
        Client1Ui.textArea1.append("\n"+"\n");

        for (int i = 0;i<1024;i++){
            bytes[i] = 0;
        }

    }

    public static void main(String[] args){
        new SendThread().start();
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
            try {
                Client1.sendMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
 }

class ReciveThread extends Thread{

    @Override
    public void run() {
        while (true){
            try {
                Client1.reciveMessage();//在这阻塞了

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




