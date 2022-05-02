package package1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ReadWriteFile {
/*
1:以UTF_8格式按行读取readFile中的内容，保存在List<String>中。
2：写入writeFile中
3：只有一个方法
 */
    public void readWrite(String readFile, String writeFile) throws IOException {

        Path path1 = Paths.get(readFile);//设置读文件路径
        FileWriter fileWriter = new FileWriter(writeFile);//实例化写文件对象
        List<String> stringList = Files.readAllLines(path1,StandardCharsets.UTF_8);//讲读文件中的内容按行保存到列表中
        int listSize = stringList.size();//循环一行一行保存
        for (int i = 0; i < listSize; i++) {
            String s = stringList.get(i);
            fileWriter.write(s+"\n");
        }
        fileWriter.close();

    }


}
