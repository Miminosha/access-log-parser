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
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;

                int totalRequests = 0;
                int googleCount = 0;
                int yandexCount = 0;

                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024) {
                        throw new RuntimeException("Обнаружена строка длиннее 1024 символов");
                    }

                    totalRequests++;

                    int lastQuote = line.lastIndexOf("\"");
                    int prevQuote = line.lastIndexOf("\"", lastQuote - 1);

                    if (prevQuote == -1 || lastQuote == -1) {
                        continue;
                    }

                    String userAgent =
                            line.substring(prevQuote + 1, lastQuote);

                    int open = userAgent.indexOf("(");
                    int close = userAgent.indexOf(")");

                    if (open == -1 || close == -1) {
                        continue;
                    }

                    String firstBrackets = userAgent.substring(open + 1, close);

                    String[] parts = firstBrackets.split(";");

                    if (parts.length < 2) {
                        continue;
                    }

                    String fragment = parts[1].trim();

                    int slashIndex = fragment.indexOf("/");
                    if (slashIndex != -1) {
                        fragment = fragment.substring(0, slashIndex);
                    }

                    if (fragment.equals("Googlebot")) {
                        googleCount++;
                    } else if (fragment.equals("YandexBot")) {
                        yandexCount++;
                    }
                }

                double googleShare =
                        totalRequests == 0 ? 0 :
                                (double) googleCount / totalRequests;

                double yandexShare =
                        totalRequests == 0 ? 0 :
                                (double) yandexCount / totalRequests;

                System.out.println("Всего запросов: " + totalRequests);
                System.out.println("Googlebot доля: " + googleShare);
                System.out.println("YandexBot доля: " + yandexShare);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
