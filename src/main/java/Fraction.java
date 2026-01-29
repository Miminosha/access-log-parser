public class Fraction extends Number{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator < 0)
            throw new IllegalArgumentException("denominator must be positive");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction sum(Fraction secondFraction) {
        int newNumerator = this.numerator * secondFraction.denominator
                + secondFraction.numerator * this.denominator;
        int newDenominator = this.denominator * secondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction sum(int number) {
        int newNumerator = this.numerator + number * this.denominator;

        return new Fraction(newNumerator, denominator);
    }

    public Fraction minus(Fraction secondFraction) {
        int newNumerator = this.numerator * secondFraction.denominator
                - secondFraction.numerator * this.denominator;
        int newDenominator = this.denominator * secondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(int number) {
        int newNumerator = this.numerator - number * this.denominator;

        return new Fraction(newNumerator, denominator);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
