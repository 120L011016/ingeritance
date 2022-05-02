package1 package1;

class MyThread extends Thread {
    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i +","+Thread.currentThread().getPriority());

            }

        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();
//        t1.start();
            //不能让已经start（）的线程去执行。会报错
//        MyThread t2 = new MyThread();
//        t2.start();
//        MyThread t3 = new MyThread();
//        t3.start();
//        MyThread t4 = new MyThread();
//        t4.start();
//        MyThread t5 = new MyThread();
//        t5.start();
//        MyThread t6 = new MyThread();
//        t6.start();
        Thread.currentThread().setPriority(1);
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i+","+Thread.currentThread().getPriority());

            }
        }
    }
}
