public class Shape{
    private int x,y;
    public void draw(){
	   System.out.println("绘图！");
	}
    
	public void test(){
	    Rectangle rectangle=new Rectangle();
		Circle circle=new Circle();
		this.draw();
		rectangle.draw();
		circle.draw();
	}
	 static public void  test1(Shape shape){
	     shape.draw();
	    if(shape instanceof Rectangle){
		    Rectangle rectangle=(Rectangle)shape;
			rectangle.area();
		}
		else
			System.out.println("This is not Rectangle!");
	}
	
	public static void main(String[] args){
 	   new Shape().test();
       Shape rectangle1=new Rectangle();
	   Shape circle=new Circle();
	   test1(rectangle1);
	   test1(circle);
	}
    


}
class Rectangle extends Shape{
	int length,width;
	public void draw(){
	   System.out.println("This is a Rectangle");

	
	}
	public void area(){
	   length=3;
	   width=2;
	   System.out.println("矩形的面积："+width*length);
	   
	} 
	


}
class Circle extends Shape{
    public void draw(){
	  System.out.println("This is a Circle");
	
	}


}

