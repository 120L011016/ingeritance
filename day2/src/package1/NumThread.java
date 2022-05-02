package1 package1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThreadTest implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class NumThread {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThreadTest numThreadTest = new NumThreadTest();
        //4.将此Callbale接口实现类的对象作为参数传递到FUtureTask构造器中，创建FUtureTask的对象
        FutureTask futureTask = new FutureTask(numThreadTest);
        //5.将FtureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）
        new Thread(futureTask).start();
        try {
            //get（）方法返回值即为FUtureTask构造器参数Callable实现类重写的call()方法的返回值。
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
