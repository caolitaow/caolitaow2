package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SameCharCount {
    List<String> list = new ArrayList();
    String lists ;
    int count = 1;
    public SameCharCount(List list) {
        this.list = list;
    }

    public void printArrays(char[] array){
        for (char c:
             array) {
            System.out.print(c+" ");
        }
        System.out.println();
    }

    public void charCout(){
        for (String s:
             list) {
            lists +=s;
        }
        char[] clists = lists.toCharArray();
        Arrays.sort(clists);
        printArrays(clists);
        for (int i = 0;i+1<clists.length;i++){
            if(clists[i]==clists[i+1]){
                count +=1;
            }else{
                System.out.println(clists[i]+"="+count);
                count = 1;
            }

        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("acve");
        list.add("aee");
        list.add("se");
        SameCharCount scc = new SameCharCount(list);
        scc.charCout();

    }
}
