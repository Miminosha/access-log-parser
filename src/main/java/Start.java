public class Start {
    public static void main(String[] args) {
        Dot dot1 = new Dot(1, 5);
        Dot dot2 = new Dot(2, 8);
        Dot dot3 = new Dot(5, 3);
        Dot dot4 = new Dot(1, 7);

        PolyLine polyLine = new PolyLine(dot1, dot2, dot3, dot4);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(dot1, dot2, dot3, dot4);

        Measurable[] lines = {polyLine, closedPolyLine};

        double result = sumOfLength(lines);
        System.out.println(result);
    }

    public static double sumOfLength(Measurable[] lines) {
        double sum = 0;
        for (int i = 0; i < lines.length; i++) {
            sum += lines[i].getLength();
        }
        return sum;
    }
}
