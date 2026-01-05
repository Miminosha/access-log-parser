public class Start {
    public static void main(String[] args) {
        Dot dot1 = new Dot(1, 3);
        Dot dot2 = new Dot(5, 8);
        Dot dot3 = new Dot(10, 11);
        Dot dot4 = new Dot(15, 19);

        Line line1 = new Line(dot1, dot2);
        Line line2 = new Line(dot3, dot4);
        Line line3 = new Line(dot2, dot3);

        System.out.println(line3 + " до изменений");

        dot2.setX(3);
        dot2.setY(7);
        dot3.setX(9);
        dot3.setY(12);

        System.out.println(line3 + " после изменений");

        double sumOfLines = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.println(sumOfLines);
    }
}

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

class Line {
    Dot start;
    Dot end;

    public Line(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public double getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
