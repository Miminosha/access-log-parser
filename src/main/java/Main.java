public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(49, 12);
        Fraction f3 = new Fraction(3, 2);
        Fraction f4 = new Fraction(1, 3);

        Number[] numbers1 = {f1, 2, 2.3};
        Number[] numbers2 = {3.6, f2, 3, f3};
        Number[] numbers3 = {f4, 1};

        System.out.println(sumAll(numbers1));
        System.out.println(sumAll(numbers2));
        System.out.println(sumAll(numbers3));
    }

    public static double sumAll(Number[] numbers) {
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        return sum;
    }
}
