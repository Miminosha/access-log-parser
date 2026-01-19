public class Start {
    public static void main(String[] args) {
        Dot dot1 = new Dot(1, 5);
        Dot dot2 = new Dot(2, 8);
        Dot dot3 = new Dot(5, 3);
        Dot dot4 = new Dot(8, 9);

        PolyLine polyLine = new PolyLine(dot1, dot2, dot3, dot4);
        double lenthOfPolyline = polyLine.getLength();

        Line line1 = new Line(dot1, dot2);
        Line line2 = new Line(dot2, dot3);
        Line line3 = new Line(dot3, dot4);

        double sumOfLines = line1.getLength() + line2.getLength() + line3.getLength();

        System.out.println(lenthOfPolyline == sumOfLines);

        System.out.println(dot2);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(polyLine);

        dot2.setX(12);

        System.out.println("---Вывод результатов после изменений---");
        System.out.println(dot2);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(polyLine);
    }
}
