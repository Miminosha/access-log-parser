import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int j = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (isDirectory || !fileExists) {
                if (!fileExists) {
                    System.out.println("Файл не существует");
                } else {
                    System.out.println("Указанный путь не ведет к файлу");
                }
                continue;
            } else
                j++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + j);
        }
    }
}