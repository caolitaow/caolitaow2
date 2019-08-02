package clt.study;

//import javax.rmi.ssl.SslRMIClientSocketFactory;

public class OFather {
    private String id;
    private String name;
    private int age;
    final static private    String  bcpasswd ="12345" ;

    OFather(){
        System.out.println("In OFather()");
    }

    OFather(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        System.out.println("In OFather(String id, String name, int age)");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        System.out.println(this);
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getBcpasswd() {
        return bcpasswd;
    }

     public void character(){
        System.out.println("父亲的性格");
    }

    protected void study(){
        System.out.println("学习");

    }

    private void secret(){
        System.out.println("银行卡密码");

    }

    /*@Override
    public String toString() {
        return "父亲的属性值："+"id: "+this.getId()+" name: "+this.getName()+
                " age: "+this.getAge()+" bank_card_password: "+this.getBcpasswd();
    }*/
}
