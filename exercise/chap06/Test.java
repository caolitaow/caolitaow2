package advanced;

        import java.util.Comparator;
        import java.util.TreeSet;

public class Test {
    //Comparator是一个独立的接口不是TreeSet类中的成员，只是按照实现了这个接口的子类规定
    //的规则比较排序
    /*TreeSet<Teacher> tree = new TreeSet<>(new Comparator<Teacher>() {
        @Override
        public int compare(Teacher o1, Teacher o2) {
            return 1;
        }
    });*/

    TreeSet<Teacher> tree = new TreeSet<>();
    public TreeSet<Teacher> getTree() {
        return tree;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.getTree().add(new Teacher(18,180));
        test.getTree().add(new Teacher(28,190));
        test.getTree().add(new Teacher(15,170));
        System.out.println(test.getTree().size());

    }

}

class  Teacher implements Comparable{
    int age;
    int height;

    public Teacher(int age, int height) {
        this.age = age;
        this.height = height;
    }


    @Override
    public int compareTo(Object o) {
        return 1;
    }

    public static void main(String[] args) {

    }
}