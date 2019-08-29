package advanced.tcpchat;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public abstract class MeChat implements Chat{
    public static boolean flag1 = false;
    public static boolean flag2 = false;

}

interface Chat{
     byte[] bytes = new byte[1024];
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //消息铃声的初始化信息
     File tone = new File("C:\\Users\\Administrator\\Music\\QQ消息音效_铃声之家cnwav.mp3");
     //主要用于输入路径名来传输文件
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}

