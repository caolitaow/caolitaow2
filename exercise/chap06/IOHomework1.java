package advanced;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOHomework1 {
    File file = new File("C:\\Users\\Administrator\\Desktop\\config.txt");
    static int count = 10;
    byte[] bytes = new byte[4];
    FileInputStream fi = new FileInputStream(file);
    FileOutputStream fo = new FileOutputStream(file);
    DataInputStream di = new DataInputStream(fi);
    DataOutputStream dos = new DataOutputStream(fo);
    public IOHomework1() throws IOException {
        dos.writeInt(count);
    }

    //试用期方法 建议用字符流处理，这种方式写进去的基本数据类型用户不能识别，计算机可识别
    void probation() throws Exception {
        int i;

            if ((i=di.readInt())!=0){
                System.out.println("您还有"+i+"次机会");
                count--;
                dos.writeInt(count);
            }else  System.out.println("请购买正版!");

        dos.flush();


    }

    void filePrint() throws IOException {
        int i = 0;
        byte[] bytes = new byte[5];
        byte[] bytes1 = new byte[1024];
        FileInputStream fi = new FileInputStream("C:\\Users\\Administrator\\Desktop\\s.txt");
        while (fi.read(bytes)!=-1){
            for (byte b: bytes) {
                    bytes1[i] = b;
                    i++;
            }
        }
        System.out.println(new String(bytes1));

        fi.close();
    }

    public static void main(String[] args) throws Exception {
        int i =10;
        IOHomework1 iow = new IOHomework1();
        iow.filePrint();
        /*while(i >= 0){
            iow.probation();
            Thread.sleep(1000);
            i--;
        }

        iow.dos.close();
        iow.di.close();*/

        //new IOHomework1().probation();
    }
}
