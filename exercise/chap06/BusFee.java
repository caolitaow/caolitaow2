package advanced;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BusFee {
    Map<String,Integer> stationmap = new HashMap<>();

    public BusFee() {
        stationmap.put("浦东软件园",1);
        stationmap.put("中创软件",2);
        stationmap.put("创业大厦",3);
        stationmap.put("托普学院",4);
        stationmap.put("阳澄湖庄",5);
        stationmap.put("湖滨路大禹路",6);
        stationmap.put("文豪花园",7);
        stationmap.put("蟹市场",8);
        stationmap.put("湖滨路迎宾路",9);
        stationmap.put("玫瑰园",10);
        stationmap.put("城北西路湖亭路",11);
        stationmap.put("葡萄研究所",12);
        stationmap.put("望河桥",13);
        stationmap.put("黄泥山村",14);
        stationmap.put("登云学院",15);
        stationmap.put("马鞍山路思常路",16);
        stationmap.put("森林公园",17);
        stationmap.put("森林半岛",18);
        stationmap.put("马鞍山路鹿城路",19);
        stationmap.put("长虹大桥",20);
    }

    public void getFee(String origin, String destiny){
        int cha;
        if(!stationmap.containsKey(origin)||!stationmap.containsKey(origin)){
            System.out.println("您上错车了！");
        }else{
            cha =Math.abs(stationmap.get(destiny)-stationmap.get(origin));//取绝对值
            if(cha != 0){
                if(cha<=4)
                    System.out.println("从"+origin+"到"+destiny+"共经过"+cha+"站，收费"+1+"元");
                else if(cha>4&&cha<=8)
                    System.out.println("从"+origin+"到"+destiny+"共经过"+cha+"站，收费"+2+"元");
                else if(cha>8&&cha<=12)
                    System.out.println("从"+origin+"到"+destiny+"共经过"+cha+"站，收费"+3+"元");
                else if(cha>12&&cha<=16)
                    System.out.println("从"+origin+"到"+destiny+"共经过"+cha+"站，收费"+4+"元");
                else
                    System.out.println("从"+origin+"到"+destiny+"共经过"+cha+"站，收费"+(4+cha-16)+"元");


            }else System.out.println("你有毒");

        }

    }

    public void inputStation(){
        System.out.print("请输入上车站：");
        String origin = new Scanner(System.in).next();
        System.out.print("请输入到达站：");
        String destiny = new Scanner(System.in).next();
        getFee(origin,destiny);
    }

    public static void main(String[] args) {
        BusFee busFee = new BusFee();
        busFee.inputStation();
    }
}
