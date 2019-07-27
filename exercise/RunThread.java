package clt.study;

/**
 *学习多线程
 *
 */
class MyThread extends Thread{

	public void run(){
		int i = 0;
		while(i < 10){
			System.out.println("The first thread is continuing...");		
			i++;
		}
	
	}

	

}

class MyThread1 extends Thread{
	
	public void run(){
		int i = 0;
		while(i < 10){
			System.out.println("The second thread is continuing...");
			i++;
		}
	}
}

/**
 *实现Runnable接口里的Run方法
 */
public class RunThread implements Runnable{
	public void run(){
		int i = 10;
		while(i > 0){
			System.out.println("RunThread");
			i--;
		}
	}
	

}

/**
 *多线程测试
 *
 **/
class TestThread{
	
	//单行注释
	/*块注释*/
	/**
	 *文档注释有自己的文档注释符
跟单行注释符，块注释符不同
	 */
	/*
	 *文档注释
	 * * */
	public static void main(String[] args){
		int i = 0;
	    MyThread thread1 = new MyThread();
		thread1.start();
		try{
			thread1.sleep(1000);
		}catch(Exception e){
			System.out.println("线程1异常");				
		}

		MyThread thread2 = new MyThread();
		thread2.start();

	    MyThread1 thread11 = new MyThread1();
		thread11.run();

		/*MyThread1 thread12 = new MyThread1();
		thread12.run();*/
		while(i < 10){
			System.out.println("Main thread is continuing");
			i++;
		}
	    RunThread run = new RunThread();
		new Thread(run).start();
	}
	

}
