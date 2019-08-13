package advanced;

class MyException extends Exception{

    MyException(){

    }

    MyException(String message){
        super(message);
    }

}

public class ExceptionTest {
    static void show(int i, int j) {
        try{
            throw new MyException("自抛自处理");
        }catch(MyException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    static int testFinally(int x, int y){

        try{
            x /= y;
            return x++;//return x 被挂起，x++得以执行,下面对x的操作及这里的x++对此
            //处return x的返回值没有影响
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally1:"+x);
            x += 12;
           // return x++;

           System.out.println("finally2:"+x);
        }
        System.out.println("testFinally:"+x);
        return x;
    }

    public static void main(String[] args) {

        System.out.println(testFinally(6,2));
           /* show(1,-1);

        int[] array = new int[5];
        try{
//            System.out.println(array[5]);
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("异常之后的代码被执行了");*/
    }
}
