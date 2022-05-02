package class101;

public class Main {
    public static void main(String[] args) {
        FileNameChange fileNameChange = new FileNameChange();
        String pathNameImage = "D:\\destop_document\\2022.4.28\\badminton_1\\photo";
        String pathNameJson = "D:\\destop_document\\2022.4.28\\badminton_1\\jason";
        fileNameChange.randomDelete(pathNameImage,pathNameJson,1,17,9);
    }
}
