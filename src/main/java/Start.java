public class Start {
    public static void main(String[] args) {
        Dot dot1 = new Dot(1, 5);
        Dot dot2 = new Dot(2, 8);
        Dot dot3 = new Dot(5, 3);
        Dot dot4 = new Dot(1, 7);

        PolyLine polyLine = new PolyLine(dot1, dot2, dot3, dot4);
        double lenthOfPolyline = polyLine.getLength();
        System.out.println(lenthOfPolyline);

        ClosedPolyLine closedPolyLine = new ClosedPolyLine(dot1,dot2,dot3,dot4);
        double lengthOfClosedPolyLine = closedPolyLine.getLength();
        System.out.println(lengthOfClosedPolyLine);
    }
}
