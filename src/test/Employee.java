package test;

import static java.lang.System.out;

//class StaticTest {
//    public static void main(String[] args) {
//        Employee [] staffs=new Employee[2];
//        staffs[0]=new Employee("a",1 );
//        staffs[1]=new Employee("b",2 );
//
//        for (Employee e:staffs){
//            out.println(e.getName()+"  says hello!"+e.getId()+"salary is: "+e.getSalary());
//        }
//        out.println("下个id是:"+Employee.getNextId());
//    }
//}


class Employeess {
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;

    public Employeess(String n, double s) {
        name = n;
        salary = s;
        id = nextId;
        nextId++;
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        out.println(x.getName());
        out.println(y.getName());
    }

    public static void main(String[] args) {
        Employeess a = new Employeess("a", 1);
        Employeess b = new Employeess("b", 2);

        Employeess temp = a;
        a = b;
        b = temp;
        out.println(a.getName() + "   " + a.getId() + "   " + a.getSalary());
        out.println(b.getName() + "   " + b.getId() + "   " + b.getSalary());
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

//    public static void main(String[] args){
//        Employee a=new Employee("a",1 );
//        Employee b=new Employee("b",2);
//        Employee temp=a;
//        swap(a, b);
//        out.println(a.getName());
//        out.println(b.getName());
//    }
}

//todo:作用域的原因?
