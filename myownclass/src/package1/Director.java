package package1;

import java.io.File;
//递归的删除文件夹和文件夹下的所有文件
public class Director {
    public boolean delFile(File fileName){
        if (fileName.delete())
            return true;
        else {
            File[] files = fileName.listFiles();
            for (File f : files){//delete childFile or childDirector
                delFile(f);
            }
            fileName.delete(); //delete parentDirector
        }
        return true;
    }
//遍历指定目录所有文件名称，包括子文件目录中的文件。并计算指定目录占用空间的大小
    public long travelDirector(File filename){
        long lenth = 0L;
        if(filename.isFile()){
            System.out.println(filename.getAbsoluteFile());
            lenth = filename.length();
        }
        else {
            File[] listFiles = filename.listFiles();
            for(File file :listFiles){
                lenth += travelDirector(file);
            }
        }
        return lenth;
    }
}
