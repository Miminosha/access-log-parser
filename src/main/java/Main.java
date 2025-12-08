import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое целое число: ");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе целое число: ");
        int number2 = new Scanner(System.in).nextInt();

        int sum = number1 + number2;
        System.out.println(number1 + " + " + number2 + " = " + sum);
        int dif = number1 - number2;
        System.out.println(number1 + " - " + number2 + " = " + dif);
        int product = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + product);
        double quotient = (double) number1 / number2;
        System.out.println(number1 + " / " + number2 + " = " + quotient);
    }
}