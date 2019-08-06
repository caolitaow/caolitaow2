package advanced;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class DragonBuster {
    Map<Integer,String> character = new HashMap<>();

    public DragonBuster() {
        character.put(1,"张君宝");
        character.put(2,"张无忌");
        character.put(3,"成昆");
        character.put(4,"小昭");

    }

    public void printMap(){
        for (Integer i:
                character.keySet()) {
            System.out.print(i+":"+character.get(i)+"  ");
        }
        System.out.println();
    }

    public void operate(){
       //双列集合无法用根接口
        printMap();

        character.put(5,"李晓红");
        printMap();

        character.remove(1);
        printMap();

        character.replace(2,"赵敏");
        printMap();


    }

    public static void main(String[] args) {
        DragonBuster db = new DragonBuster();
        db.operate();
    }
}
