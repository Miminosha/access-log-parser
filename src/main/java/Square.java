public class Square {
    Dot dot;
    private int sideLength;

    public Square(Dot dot, int sideLength) {
        if (sideLength < 0)
            throw new IllegalArgumentException("length of side must be positive");
        this.dot = dot;
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength < 0)
            throw new IllegalArgumentException("length of side must be positive");
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + dot + " со стороной " + sideLength;
    }
}