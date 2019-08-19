package advanced;

import java.io.*;
import java.util.TreeSet;

class Students implements Comparable, java.io.Serializable {
    String name;
    int age;
    int score;
    static final long serialVersionUID = 100;//固定序列化版本的UID
    static TreeSet<Students> students = new TreeSet<>();
    public Students(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Students s = (Students) o;
        if (this.name.compareTo(s.name) != 0) {
            return this.name.compareTo(s.name);
        } else if (this.age - s.age != 0) {
            return this.age - s.age;
        } else if (this.score - s.score != 0) {
            return this.score - s.score;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "["+name+"  "+age+"  "+score+"]";
    }
}
public class IOHomework2 {
    static void writeInformation(TreeSet<Students> students) throws IOException {
        FileOutputStream fw = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Students.txt");
        ObjectOutputStream oi = new ObjectOutputStream(fw);
        for (Students s:
             students) {
            oi.writeObject(s);
        }
    }

    static void readInformation() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("C:\\Users\\Administrator\\Desktop\\Students.txt");
        ObjectInputStream os = new ObjectInputStream(fi);
        Object o;
        try{
            while((o =os.readObject())!=null){
                Students s = (Students) o;
                System.out.println(s);
            }
        }catch (EOFException e) {
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Students s1 = new Students("cc",18,98);
        Students s2 = new Students("cc",18,88);
        Students s3 = new Students("aa",18,88);
        Students s4 = new Students("bb",18,88);
        Students s5 = new Students("aa",19,88);
        Students s6 = new Students("aa",29,88);
        Students.students.add(s1);
        Students.students.add(s2);
        Students.students.add(s3);
        Students.students.add(s4);
        Students.students.add(s5);
        Students.students.add(s6);
        writeInformation(Students.students);
        readInformation();
    }


}
