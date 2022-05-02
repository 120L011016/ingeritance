package1 package2;
/*
    1：接口使用上也满足多态性
    2：接口 ：实际上就是定义了一种规范
    3：开发中，体会面向接口编程
 */
public class USBTest {
    public static void main(String[] args) {
        Computer com = new Computer();
        //1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        com.trainsferData(flash);
        //2.创建了接口的非匿名实现类的匿名对象
        com.trainsferData(new Flash());
        //3.创建了接口的匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        };
        com.trainsferData(phone);
        //4. 创建了接口的匿名实现类的匿名对象
        com.trainsferData(new USB(){

            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        });
    }
}

class Computer{
     public void trainsferData(USB usb){ //USB usb = new Flsh();
         usb.start();
         System.out.println("具体的传输数据细节");
     }
}
interface USB{
    //属性常量：长宽，最大最小传输速度
    void start();
    void stop();
}

class Flash implements  USB{

    @Override
    public void start() {
        System.out.println("U盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");

    }
}
