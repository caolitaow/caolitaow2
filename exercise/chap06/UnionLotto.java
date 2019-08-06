package advanced;

import java.awt.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择；
 * 请随机生成一注双色球号码。（要求同色号码不重复）
 * */
public class UnionLotto {

    //TreeSet<Integer> treeset = new TreeSet<>();
    Set<Integer> redset = new HashSet<>();
    //Set<Integer> blueset = new HashSet<>();
    int blueball;

    public UnionLotto() {

        this.blueball = (int)(Math.random()*16)+1;
        //blueset.add(blueball);

    }

    public void setRedset() {
      //  int i = 0;
        int num;
        while (redset.size()<6){
            //(int)Math.random()*33+1实际上是（int）Math.random()再乘以33即一直都是0*33+1=1；
            num = (int)(Math.random()*33)+1;
           // System.out.println(num);
            redset.add(num);
            //i++;
        }

    }

    public void generateUL(){
        int i;
        setRedset();
        /*treeset = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.equals(o2) ? 1 : 9;
            }
        });*/
       /* treeset.addAll(redset);
        treeset.addAll(blueset);*/
        for (Integer o:
             redset) {
            if(o<Integer.valueOf(10)){
                System.out.println("0"+o);
                continue;

            }
            System.out.println(o);
        }
        if(blueball<10){
            System.out.println("0"+blueball);

        }else{
            System.out.println(blueball);
        }

       /* g.setColor(Color.blue);
        g.drawArc(200,200,100,100,0,360);*/
    }

    public static void main(String[] args) {
        UnionLotto ul = new UnionLotto();
        ul.generateUL();
    }
}
