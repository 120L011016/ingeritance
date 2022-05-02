package1 package3;

public class SubClass {
    public static void main(String[] args) {
        Subclass s = new Subclass();
        // 通过实现类的对象，可以直接调用接口中的默认方法。
        //如果实现类重写了接口中的摩尔万能方法，调用时，调用的是重写后的方法。
        s.method2();
        //接口中定义的静态方法，只能通过接口来调用；
        CompareA.method1();
        //如果子类继承了父类和实现的接口中声明了同名同参数的当打，那么子类在没有重写此方法的情况下，会优先调用父类的方法--》类优先原则
        //如果实现类实现了多个接口，多个接口中定义了同名同参数的方法，那么就会发生接口冲突，那么必须在实现类中重写此方法。
        System.out.println("hello");
    }
}

class Subclass implements CompareA{

}
