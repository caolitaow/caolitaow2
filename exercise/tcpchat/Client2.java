package advanced.tcpchat;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Client2 extends MeChat{

    //空字符串用于接受用户的消息
    public static String recivemessage="";
    static String sendmessage="";
    static ServerSocket c1;
    static Date date;
    static Player player;

    //static Socket c2_1;

   /* static {
        try {
            c2_1 = new Socket("127.0.0.1",7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

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

    public static void sendMessage() throws IOException {
        OutputStream os = c2.getOutputStream();
        BufferedOutputStream bo= new BufferedOutputStream(os);
        sendmessage = Client2Ui.messageSend;
        if (flag2){
            return;
        }
        bo.write(sendmessage.getBytes());
        bo.flush();
        flag2 = true;

    }

    public static void reciveMessage() throws IOException {
        FileInputStream fi = new FileInputStream(tone);
        BufferedInputStream bi1 = new BufferedInputStream(fi);
        InputStream is = c2.getInputStream();
        BufferedInputStream bi = new BufferedInputStream(is);
         bi.read(bytes);
         //开始播放音频
        try {
            player = new Player(bi1);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

        date = new Date();
        recivemessage = new String(bytes);//收到的消息
       // System.out.println("客户端的内容呢"+"0000");//拼接上recivemessage跟它拼接的字符串就消失了？
        System.out.println("客户端："+recivemessage);//显示在控制台上给用户看
        Client2Ui.textArea1.append(dateFormat.format(date)+"\n");
        Client2Ui.textArea1.append(Client2.recivemessage);
        Client2Ui.textArea1.append("\n"+"\n");

       for (int i = 0;i<1024;i++){
           bytes[i] = 0;
       }

    }

    public static void main(String[] args) {
        System.out.println("开启线程Client2");
        new SendThread1().start();
        new ReciveThread1().start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client2Ui().setVisible(true);
            }
        });

    }
}
class SendThread1 extends Thread{

    @Override
    public void run() {
        while (true) {
            try {
                Client2.sendMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReciveThread1 extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Client2.reciveMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}









