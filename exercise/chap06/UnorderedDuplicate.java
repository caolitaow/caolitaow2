
 package advanced;


/* 在一个集合中存储了无序并且重复的字符串，定义一个方法，
让其有序（字典排序）还不能去除重复的元素输出。*/

 import java.util.*;

 public class UnorderedDuplicate {
     List<String> list = new ArrayList<>();
     TreeSet<String> set = new TreeSet<>();

     public UnorderedDuplicate(List<String> list) {
         list.add("ei");
         list.add("zef");
         list.add("aff");
         list.add("sff");
         this.list = list;
     }

     public void stringList(){
         Object[] os =list.toArray() ;
         String[] lists = new String[os.length];
         String temp;
         int j,r;
         for (int p = 0;p<os.length;p++){
             lists[p]=(String) os[p];
         }
         for (int i = 0;i<lists.length;i++){
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
         }

     }

     public TreeSet unorderDuplicate(){

         TreeSet<String> treeset = new TreeSet<String>(new Comparator() {
             @Override
             public int compare(Object o1, Object o2) {
                if(o1.equals(02)){
                    return  1;
                }else{
                    return  3;
                }
             }
         });
         stringList();
         treeset.addAll(list);


         return treeset;
     }

     public static void main(String[] args) {
         UnorderedDuplicate ud = new UnorderedDuplicate(new ArrayList<String>());

         System.out.println(ud.unorderDuplicate());
     }

 }
