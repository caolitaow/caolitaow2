
 package advanced;


/* 在一个集合中存储了无序并且重复的字符串，定义一个方法，
让其有序（字典排序）还不能去除重复的元素输出。*/

 import java.util.*;

 public class UnorderedDuplicate {
     List<String> list = new ArrayList<>();
     //Comparator是函数式接口因此适合Lambda表达式
     TreeSet<String> treeset = new TreeSet<String>(( o1,o2)->{
         int result = o1.compareTo(o2);
         return result == 0 ? 1 : result;});

     public UnorderedDuplicate() {
         list.add("ei");
         list.add("bef");
         list.add("aff");
         list.add("aff");
         list.add("sff");

     }

     public void treeSetList(){
         for (String s:
              list) {
             treeset.add(s);
         }

         treeset.forEach(System.out::println);//Lambda表达式JdK1.8新特性
        /* for (int i = 0;i<lists.length;i++){
             r=i;
             for (j=i+1;j<lists.length;j++){
                 if(lists[i].compareTo(lists[j])>0){
                    i=j;
                 }
             }
             if(r!=i){
                 temp = lists[i];
                 lists[i] = lists[r];
                 lists[r] = temp;
             }
             i=r;
         }
         list.clear();
         for (String s:
              lists) {
             list.add(s);
         }*/

     }

     public static void main(String[] args) {
         UnorderedDuplicate ud = new UnorderedDuplicate();
         ud.treeSetList();
     }

 }
