package advanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IO流的相关作业
 */
public class IOHomework {
    static String filePath1;
    static String filePath2;
    List<String> lines = new ArrayList<>();
    String line,liness="";//一定得赋空值，否则默认为null,而null也被当作
    //字符串相加了


    File file1;
    File file2;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;

    FileInputStream fi;
    FileOutputStream fo;
    BufferedInputStream bi;
    BufferedOutputStream bo;

    public IOHomework(String filePath1, String filePath2) throws IOException {
         file1 = new File(filePath1);
         file2 = new File(filePath2);
         fr = new FileReader(file1);
         fw = new FileWriter(file2);//为什么这里改成file1，内容就写不进去了？
         br = new BufferedReader(fr);
         bw = new BufferedWriter(fw);
    }

     IOHomework(String stream, String filePath1, String filePath2) throws FileNotFoundException {
         file1 = new File(filePath1);
         file2 = new File(filePath2);
         fi = new FileInputStream(file1);
         fo = new FileOutputStream(file2);
         bi = new BufferedInputStream(fi);
         bo = new BufferedOutputStream(fo);
    }

    void bwClose() throws IOException {
        bw.close();
        fw.close();
        br.close();
        fr.close();
    }

    void boClose() throws IOException {
        bo.close();
        fo.close();
        bi.close();
        fi.close();
    }

    void setLines() throws IOException {
        while((line=br.readLine())!=null){
            lines.add(line);
        }
    }
    //文本反转
    public void TextInversion() throws IOException {
        int i;
        setLines();
        i = lines.size()-1;
        while (i >= 0){
            System.out.println(lines.get(i));
            bw.write(lines.get(i));
            bw.newLine();
            i--;
        }
        bw.flush();
        bwClose();
    }

    //统计文本中字符的个数,将结果写在count.txt中
    void charCount() throws IOException {
        char[] array;
        int count = 1;
        int j = 0;
        setLines();
        for (String line:
             lines) {
             liness += line;
        }
        array = liness.toCharArray();
        Arrays.sort(array);
        System.out.println(array.length);
        /*for(int i = 0;i< array.length;i++){
            System.out.println(array[i]);
        }*/

        for (int i = 0;i< array.length;i++){
            j = i+1;
            if(j!=array.length){
                if(array[i]!=array[j]){
                    System.out.println(array[i]+"="+count);
                    bw.write(array[i]+"="+count);
                    bw.newLine();
                    count = 1;
                }else
                    count++;
            }else {
                System.out.println(array[i]+"="+count);
                bw.write(array[i]+"="+count);
            }



        }
        bw.flush();
        bwClose();



    }

    public static void main(String[] args) throws IOException {
        filePath1 = "C:\\Users\\Administrator\\Desktop\\s.txt";
        filePath2 = "C:\\Users\\Administrator\\Desktop\\count.txt";
        IOHomework iow1 = new IOHomework(filePath1,filePath2);
        //iow1.TextInversion();
        iow1.charCount();
    }
}
