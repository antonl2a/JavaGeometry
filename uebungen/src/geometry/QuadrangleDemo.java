package geometry;

public class QuadrangleDemo {
	public static void main(String[] args) {
		Quadrangle quadrangle1 = new Quadrangle();
		Point point1 = new Point(2, 2);
		Point point2 = new Point(8, 1);
		Point point3 = new Point(6, 8);
		Point point4 = new Point(3, 6);
		
		Quadrangle quadrangle2 = new Quadrangle();
		
		Point[] points = {
				new Point(2, 2),
				new Point(13, 2),
				new Point(8, 6),
				new Point(4, 6)
				};
		
		Quadrangle quadrangle3 = new Quadrangle(points);
		Quadrangle quadrangle4 = new Quadrangle(quadrangle3);
		Quadrangle quadrangle5 = new Quadrangle();
		quadrangle5.initialize();
		quadrangle1.print();
		quadrangle2.print();
		quadrangle3.print();
		quadrangle4.print();
		quadrangle5.print();
	}
}
