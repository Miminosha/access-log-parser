public class Line implements Measurable {
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
