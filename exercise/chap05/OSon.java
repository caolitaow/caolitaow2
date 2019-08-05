package clt.study;

public class OSon extends OFather {
    private int salary;

    OSon(){
        //this(100000);
        System.out.println("In OSon()");
    }

    OSon(int salary){
        this();
        this.salary = salary;
        this.setId("00000");
        this.setName("操礼涛");
        this.setAge(22);
        System.out.println("In OSon(int salary)");
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * 通过重写父类的set方法，来给自己继承过来的私有属性赋值，
     * 其实还是调用父类的公有方法（相当于父类授权过了）set方法给自己继承的成员赋值
     */
    @Override
    public void setId(String id) {

        super.setId(id);

    }

    @Override
    public void setName(String name) {
        //System.out.println();
        super.setName(name);

    }

    //@Override
    public void character() {
        System.out.println("儿子的性格");
       // super.character();
    }

    /*@Override
    public String toString() {
        return "儿子的属性值："+"id: "+this.getId()+" name: "+this.getName()+
                " age: "+this.getAge()+" salary: "+this.getSalary();
    }*/
}
