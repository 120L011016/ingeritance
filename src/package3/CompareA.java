package1 package3;
/*
    1: JDK8:除了定义上面两个，还可以定义静态方法、默认方法
 */
public interface CompareA {
    //静态方法
    public static void method1(){
        System.out.println("CompareA:北京");
    }
    //默认方法
    public default void method2(){
        System.out.println("CompareA:上海");
    }
}
