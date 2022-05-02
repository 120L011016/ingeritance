package class101;


import java.util.Scanner;

public class HIndex {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] citations = new int[100];
            String[] strs;
            System.out.println("input:");
            String line = scanner.nextLine();
            strs = line.split(",");
        //应用方法对strs中的值进行从到到小排顺序
        System.out.println("*******************");
        System.out.println(strs);

        //组织方式：   属性    方法
        //属性有：数组  index 方法有：计算出index
    }
}
