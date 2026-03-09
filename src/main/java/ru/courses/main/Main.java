package ru.courses.main;

import ru.courses.parser.LogEntry;
import ru.courses.statistics.Statistics;

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

            Statistics statistics = new Statistics();

            try {

                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);

                String line;

                while ((line = reader.readLine()) != null) {

                    if (line.length() > 1024) {
                        throw new RuntimeException("Строка длиннее 1024 символов");
                    }

                    try {

                        LogEntry entry = new LogEntry(line);
                        statistics.addEntry(entry);

                    } catch (Exception ex) {

                        System.out.println("Ошибка строки:");
                        System.out.println(line);

                    }
                }

                System.out.println("Средний трафик в час: "
                        + statistics.getTrafficRate());

                System.out.println("Несуществующие страницы:");
                for (String page : statistics.getListOfUnexistingPages()) {
                    System.out.println(page);
                }

 /*
                System.out.println("Существующие страницы:");
                for (String page : statistics.getListOfExistingPages()) {
                    System.out.println(page);
                }

                System.out.println("Статистика ОС:");
                for (String os : statistics.getOsStatistics().keySet()) {
                    System.out.println(os + ": " + statistics.getOsStatistics().get(os));
                }
  */

                System.out.println("Статистика браузеров:");
                for (String browser : statistics.getBrowserStatistics().keySet()) {
                    System.out.println(browser + ": " + statistics.getBrowserStatistics().get(browser));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}