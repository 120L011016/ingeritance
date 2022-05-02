package zeng.file;


import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class MyFileTest {
//    public static void main(String[] args) {
//        File file = new File("Action_1");
//        this.delFile(file);
//    }
    @Test
    public void test1() throws IOException {
        //构造器1
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\workspace_idea\\JavaSenic\\IO\\hello.txt");
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:\\workspace_idea\\JavaSenior", "hello.txt");
        System.out.println(file3);
        System.out.println(file1.getCanonicalPath());

        //构造器3
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);

    }
    @Test
    public void test2(){
        String fileName1 = "C:/Users/wentao zeng/Desktop/zuoye.txt";
        String fileName2 = "C:/Users/wentao zeng/Desktop/Action.sh";
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        System.out.println(file1.length());
        System.out.println(file2.length());
        System.out.println(new Date(file1.lastModified()));
    }
    @Test
    public void test4(){
        File file1 = new File("Action_1.sh");
        File file3 = new File("C:/Users/wentao zeng/Desktop/Action_1.sh");
        File file2 = new File("C:/Users/wentao zeng/Desktop/Action—.sh");
        boolean renameTo = file2.renameTo(file3);//实现了该名操作
        boolean renameTo1 = file2.renameTo(file1);//实现了改名操作和替换位置功能
        System.out.println(renameTo);
        System.out.println(renameTo1);
        System.out.println(file3.canRead());
        System.out.println(file3.isHidden());

    }
    @Test
    public void test5(){
        String name = null;
        File file = new File("Action_1");
        File file2 = new File(name);
        File file1 = new File("Action_1/ac");
//        boolean mkdirs = file1.mkdirs();
//        System.out.println(file.delete());//想要删除成功，那么该目录下不能有子目录
        //递归的删除文件夹和文件夹下的所有文件
        System.out.println(file2.getName());

    }
    //递归的删除文件夹和文件夹下的所有文件
    public static boolean delFile(File fileName){
        if (fileName.delete())
            return true;
        else {
            File[] files = fileName.listFiles();
            for (File f : files){
                delFile(f);
            }
            fileName.delete();
        }
        return true;
    }
    @Test
    public void test6(){

    }




}
