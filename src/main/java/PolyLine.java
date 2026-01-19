import java.util.ArrayList;

public class PolyLine {
    ArrayList<Dot> dots;

    public PolyLine() {
        dots = new ArrayList<>();
    }

    public PolyLine(Dot... dotsArray) {
        dots = new ArrayList<>();

        for (int i = 0; i < dotsArray.length; i++) {
            dots.add(dotsArray[i]);
        }
    }

    public Line[] getLines() {

        if (dots.size() < 2) {
            return new Line[0];
        }

        Line[] lines = new Line[dots.size() - 1];

        for (int i = 0; i < dots.size() - 1; i++) {
            lines[i] = new Line(dots.get(i), dots.get(i + 1));
        }

        return lines;
    }

    public double getLength() {

        double length = 0;
        Line[] lines = getLines();

        for (int i = 0; i < lines.length; i++) {
            length += lines[i].getLength();
        }

        return length;
    }

    @Override
    public String toString() {
        return "Линия " + dots;
    }
}
