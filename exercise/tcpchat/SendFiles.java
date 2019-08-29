package advanced.tcpchat;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传送文件
 * UDP虽然不可靠但编写简单
 * dp1.getData()[0]
 * */
public class SendFiles {
    public static void main(String[] args) throws IOException {
        new SendThread0().start();
        new ReciveThread0().start();
    }
}

class SendThread0 extends  Thread implements Chat {

    @Override
    public void run() {
        try {
            int port =45678;//这里端口不能跟TCP编程的端口一致
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("127.0.0.1");//255表示在172.16.10.x这个网段
            //下所有的主机都能接收到本机发出的数据包
            //BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            String line1;
            while (true){

                try {
                    String filePath = br.readLine();
                    File file = new File(filePath);
                    FileInputStream fi = new FileInputStream(file);
                    BufferedReader reader1 =new BufferedReader(new InputStreamReader(fi));//读取文件

                    //将文件名发过去，好让对方复制
                    byte[] bytes1 =filePath.getBytes();
                    int length1 = bytes1.length;
                    DatagramPacket dp1 = new DatagramPacket(bytes1,length1,ia,port);
                    ds.send(dp1);

                    //发送完一个文件
                    while ((line1 = reader1.readLine())!=null){
                        byte[] bytes =line1.getBytes();
                        int length = bytes.length;
                        DatagramPacket dp = new DatagramPacket(bytes,length,ia,port);
                        ds.send(dp);
                    }
                    //文件传完后再发一个标志告诉对方我要发送下一个文件了
                    byte[] bytes = {(byte)100};
                    DatagramPacket dp = new DatagramPacket(bytes,1,ia,port);
                    ds.send(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // line =reader.readLine();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReciveThread0 extends Thread{

    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(45678);
            byte[] bytes = new byte[1024*64];
            int length = bytes.length;
            while (true){

                //接收到的文件名
                DatagramPacket dp = new DatagramPacket(bytes,length);
                ds.receive(dp);
                byte[] bytes1 = dp.getData();
                int length1 =dp.getLength();
                String data =new String(bytes1,0,length1);//路径
                String[] filePath = data.split("\\\\");
                System.out.println(filePath[filePath.length-1]);//打印文件名

                FileOutputStream fo = new FileOutputStream("D:\\"+filePath[filePath.length-1]);
                OutputStreamWriter ow = new OutputStreamWriter(fo);
                BufferedWriter bw = new BufferedWriter(ow);

                //得跳出循环，不然传第二个文件时，文件名还是用下面的dp1接收的话，会被当成是第一个文件
                //的内容将第二个文件的内容写进去，得跳出循环重新给输出流一个文件
                while (true){

                    DatagramPacket dp1 = new DatagramPacket(bytes,length);
                    ds.receive(dp1);//接收到了来自其他主机所发送的数据包并写到dp对象中
                    //类似于TCP中的ServerSocket对象调用accept()接收传过来的Socket对象完成通信
                    if (dp1.getData()[0]==(byte)100)break;//通过dp1里得byte[]数组中的第一个元素是否为100来
                    //判断是否接收到数据，决定是否跳出循环
                    String sIP = dp1.getAddress().getHostAddress();
                    byte[] bytes2 = dp1.getData();
                    int length2 =dp1.getLength();
                    String fdata =new String(bytes2,0,length2);
                    System.out.println(sIP+"\t说"+fdata);

                    //将读到的文件写进另一个文件中，就完成了文件的互传
                    bw.write(fdata);
                    bw.newLine();
                    bw.flush();

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
