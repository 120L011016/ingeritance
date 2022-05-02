package1 package2;
/*
    接口的使用：
    1：结构使用interface来定义
    2:Java中，接口和类式并列的两个结构
    3：如何定义结构：定义接口中的成员
        3.1 JDK7和以前：只能够定义全局常量和抽象方法
            >全局常量：public static final ,但是书写时，可以省略不写，因为我们已经默认了
            >抽象方法：public abstract
        3.2 JDK8:除了定义上面两个，还可以定义静态方法、默认方法
    4.接口不能实例化，因为接口中不能定义构造器。
    5.Java开发中，接口通过让类去实现的方式来使用
        如果实现类覆盖了接口中的所有首相方法，则此实现类就可以实例化
        否则，此实现类仍是一个抽象类
    6: Java 类可以实现多个接口 --->弥补了Java单继承的局限性
        格式： class AA extends BB implements  CC,DD,EE
    7: 接口与接口之间可以继承，而且可以多继承
    **********************************************
    8： 接口的具体使用，体现多态性
    9：接口可以看作是一种规范


 */

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane plane = new Plane();
        plane.fly();
    }
}

interface Flyable{
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;

    public abstract  void fly();
    void stop();  //也可以省略 public abstract
}

interface Attackable{

    void atack();
}

class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("飞机可以起飞");
    }

    @Override
    public void stop() {
        System.out.println("飞机可以停止");

    }
}

abstract class Kite implements Flyable{

    @Override
    public void fly() {

    }

//    @Override
//    public void stop() {
//
//    }
}

class Bullet extends Object implements Flyable,Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void atack() {

    }
}
