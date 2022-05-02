package class101;

import java.io.File;
import java.util.Objects;
import java.util.Random;

/**
 * public String getName() ：获取名称
 * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 * File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 */
public class FileNameChange {

    public void imageJsonRenumber(String filePath){

        File file = new File(filePath);
        File[] files = file.listFiles();
        String[] strings = file.list();
        int len = strings.length;
        int j=0;
        for (int i = 0; i < len-2; i+=2) {
            try{
                files[i].renameTo(new File(file,j+".jpg"));
                files[i+1].renameTo(new File(file,j+".json"));
                //事实告诉我们新改变的名字下表会自动变为原来位置的下标。
                j++;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void randomDelete(String filePathImage,String filePathJson, int start, int end,int num){
        //开始start直接数项目中的第一个，下面会减1，end 也是
        start--;
        end--;
        File file1 = new File(filePathImage);
        File file2 = new File(filePathJson);
        //File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
        File[] files1 = file1.listFiles();
        File[] files2 = file2.listFiles();
        Random random = new Random();
        for (int k = 0; k < num; k++) {
            int i = random.nextInt(end - start + 1) + start;
            //这里会产生删除数量不达期望的问题，无法避免每次循环产生的的伪随机数不相等的问题。
            //问题，每次减会造成files1列表随时更新，下表也会发生变化。也就是说这个file[]是动态的。

            while (files1[i]==null){
                i = random.nextInt(end - start + 1) + start;
            }
            files1[i].delete();
            files2[i].delete();
        }
    }

}
