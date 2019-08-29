package advanced.tcpchat;

import java.io.IOException;
import java.util.*;

/**
 * 用户类
 * 当没有注册过的用户登录时，会自动将刚刚的登录信息拿去注册
 * 下次再输入之前的信息就能登录成功
 * */
public class User {
    private int id;
    private String name;
    private String password;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    static boolean flag = false;
    //存放用户登录信息
    private static Map<Integer,User> userMap = new HashMap<>();

    public static void setUserMap() {
        userMap.put(1,new User(1,"操礼涛","123456"));
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    //将用户登录信息存入Map集合中【类似于数据库】
    public static void register(String name, String password){
        int id = random.nextInt(1000);//最多存放1000个用户信息
        userMap.put(id,new User(id,name,password));
    }

    public static void login(){

        String name = scanner.next();
        String password = scanner.next();
        Set<Integer> keySet = userMap.keySet();
        for (Integer i:
             keySet) {
            if (name.equals(userMap.get(i).name) && password.equals(userMap.get(i).password)){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("登录成功");
            //分别加载Client2.java和Client1.java,直接调用两个文件的主线程
         /*   Client2.main(new String[1]);
            Client1.main(new String[1]);*/
        }else {
            System.out.println("登录失败，请先注册");
            register(name,password);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(userMap.size());
            login();
        }

    }


    public static void main(String[] args) throws IOException {
        //这里有个bug:只要有一个用户登录成功就会同时开启自己和对方的聊天界面
        //这是不合理的，但由于是TCP聊天所以若要实现两个用户同时登录才能聊天
        //必须先开启作为服务端的Client2,即必须让负责启动Client2线程的用户先登录程序
        //这显然不合理，若先开Client1就会报错，停止执行
       // System.out.println("执行完之后才启动后面的两个线程");
        login();
        new Thread("Client2"){
            @Override
            public void run() {
                Client2.main(new String[1]);
            }
        }.start();
        new Thread("Client1"){
            @Override
            public void run() {
                System.out.println("开启线程Client1");
                Client1.main(new String[1]);//主线程main()可以直接调用执行
            }
        }.start();

        //当两个用户都上线了才开启传送文件的功能
        SendFiles.main(new String[1]);

    }
}


