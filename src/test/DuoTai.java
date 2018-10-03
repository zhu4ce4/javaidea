package test;

import static java.lang.System.out;

class Father {
    static String tezheng = "满面皱纹";
    String name = "花括号";
    String age = "88";
    String sex = "man";
    String weight = "40kg";

    public static void self_introduction() {
        out.println("我的名字叫：花括号，我的年龄是：88，我的性别是：man");
    }

    public void kongFu() {
        print("三脚猫");
    }

    public void print(Object ob) {
        System.out.println(ob);
    }
}

class Daughter extends Father {
    static String face = "秀色可餐";
    String name = "花木兰";
    String age = "28";
    String sex = "femal";
    String height = "180cm";

    public static void self_introduction() {
        out.println("我的名字叫：花木兰，我的年龄是：28，我的性别是：female");
    }

    public void kongFu() {
        print("横扫千军");
    }

    public void tuzhimofen() {
        print("花枝招展");
    }
}

public class DuoTai {
    public static void main(String[] args) {
        Father n = new Daughter();    //女儿伪装成父亲；
        n.print(Father.tezheng);
        n.print(n.tezheng);
        Father.self_introduction();
        n.self_introduction();  //静态方法需要使用类名调用，因而静态方法调用的是父类的；
        Daughter.self_introduction();//如用子类的类名调用静态方法，自然是调用子类的，但若子类没有该静态方法，则是调用父类的；
        n.print(n.weight);  //可以调用父类特有的变量；
        n.print(n.name);    //虽然子类有相同的变量，但调用得是父类的变量；
        n.print(n.age);
        n.print(n.sex);
//        n.print(n.height);    //不能调用子类特有的变量；
        n.kongFu();     //非静态方法调用的是子类的，前提是该方法时覆写父类产生的；
//        n.tuzhimofen();   //不能调用子类特有的方法；

        n.print("*************上面是伪装为父类********************上面是子类*******************");

//        Daughter d=new Daughter();
        Daughter d = (Daughter) n;
        d.print(Daughter.tezheng);
        d.print(Daughter.face);
        d.print(d.tezheng);
        d.print(d.face);
        d.print(d.height);
        d.print(d.weight);
        d.print(d.name);
        d.print(d.age);
        d.print(d.sex);
        d.self_introduction();
        Daughter.self_introduction();
        d.kongFu();
        d.tuzhimofen();
    }
}

/*https://www.zhihu.com/question/30082151
 * 那么我们可以根据以上情况总结出多态成员访问的特点：
 * 成员变量: 编译看左边(父类),运行看左边(父类)
 * 成员方法: 编译看左边(父类)，运行看右边(子类)。动态绑定(如子类有复写父类该方法，调用子类该方法，而如果子类并没有复写父类该方法，只能调用父类的该方法）
 * 静态方法: 编译看左边(父类)，运行看左边(父类)。由于静态的方法是与类绑定的，故始终调用父类的方法。
 * (静态和类相关，算不上重写，所以，访问还是左边的)
 * 只有非静态的成员方法,编译看左边,运行看右边
 *
 * 多态的弊端：不能使用子类特有的成员属性和子类特有的成员方法。
 */
