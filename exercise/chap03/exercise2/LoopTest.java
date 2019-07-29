public class LoopTest{
	public void multi(){
	   int result=1;
	   int i=2;
	   while(i<11){
	      result*=i;
	      i++;
	   }
	   System.out.println("i="+i+'\t'+"result="+result);
	   result=1;
	   i=2;
	   do{
	     result*=i;
		 i++;
	   
	   }while(i<11);
	   System.out.println("i="+i+'\t'+"result="+result);
	   result=1;
	   for(i=2;i<11;i++){
	     result*=i;
	   
	   }
	   System.out.println("i="+i+'\t'+"result="+result);
	}
	
	
	
	public static void main(String[] args){
		LoopTest lop=new LoopTest();
		
		lop.multi();
	
	
	}




}
