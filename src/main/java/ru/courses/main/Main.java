package ru.courses.main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int j = 0;

        while (true) {
            String path = scanner.nextLine();
            File file = new File(path);

            if (!file.exists()) {
                System.out.println("Файл не существует");
                continue;
            }

            if (file.isDirectory()) {
                System.out.println("Указанный путь не ведет к файлу");
                continue;
            }
            j++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + j);

            try {
                int linesCount = 0;
                int maxLength = 0;
                int minLength = Integer.MAX_VALUE;

                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;

                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024) {
                        throw new RuntimeException(
                                "Обнаружена строка длиннее 1024 символов");
                    }
                    linesCount++;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    if (length < minLength) {
                        minLength = length;
                    }
                }
                reader.close();
                System.out.println("общее количество строк в файле = " + linesCount);
                System.out.println("длина самой длинной строки в файле = " + maxLength);
                System.out.println("длина самой короткой строки в файле = " + minLength);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
