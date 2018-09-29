package test;

import static java.lang.System.out;

public class ParamTest {
    public static void main(String[] args) {
//        out.println("测试翻倍value");
//        double percent = 10;
//        out.println("测试前" + percent);
//        tripleValue(percent);
//        out.println("测试后" + percent);
//
//        out.println("测试翻倍salary");
//        Employee harry = new Employee("harry", 50000);
//        out.println("之前" + harry.getSalary());
//        tripleSalary(harry);
//        out.println("之后" + harry.getSalary());

        out.println("测试交换：");
        Employee a = new Employee("alice", 70000);
        Employee b = new Employee("bob", 60000);
        out.println("之前" + a.getName());
        out.println("之前" + b.getName());
        swap(a, b);
        out.println("方法后" + a.getName());
        out.println("方法后" + b.getName());
        out.println("方法后 a.salary=" + a.getSalary());
        out.println("方法后 b.salary=" + b.getSalary());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        out.println("方法后x=" + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        out.println("方法后salary=" + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
//        x.setName("bob");
//        y.setName("alice");
//        out.println("方法中 x=" + x.getName());
//        out.println("方法中 x.salary=" + x.getSalary());
//        out.println("方法中 y=" + y.getName());
//        out.println("方法中 y.salary=" + y.getSalary());

        Employee temp = x;
        x = y;
        y = temp;
        out.println("方法中： x=" + x.getName());
        out.println("方法中： y=" + y.getName());
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String aname) {
        name = aname;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

//todo:作用域的影响？
