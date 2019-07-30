class Fu {
     public int num = 10;
     public Fu() {
         System.out.println("fu");
     }
 }
 
 class Zi extends Fu {
     public int num = 20;
     public Zi() {
         System.out.println("zi");
     }
     public void show() {
         int num = 30;
         System.out.println(num); 
         System.out.println(this.num); 
         System.out.println(super.num);
     }
 
 }

/**
 *fu
  zi
  30
  20
  10
 * */
 class ExtendsTest {
     public static void main(String[] args) {
         Zi z = new Zi();
         z.show();
     }
 }

