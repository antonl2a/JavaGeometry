package geometry;

import javafx.scene.shape.Shape;

public class Eclipse extends GeometricObject{
	//private Point startPoint;
	private double a;
	private double b;	
	
	
	public Eclipse() {
		//startPoint = new Point(0, 0);
		super("Eclipse", 1, 0);
		a = 1;
		b = 1;
		points[0] = new Point(0,0);
	}
	
	public Eclipse(Point startPoint, double height, double width) {
		super("Eclipse", 1, 0);
		this.points[0] = new Point(startPoint);		
		this.a = height;
		this.b = width;
	}
	
	public Eclipse(Eclipse otherEclipse) {
		super("Eclipse", 1, 0);
		points[0] = new Point(otherEclipse.points[0]);
		a = otherEclipse.a;
		b = otherEclipse.b;
	}
	@Override
	public boolean isValid() {
		return a > 0 && b > 0;
	}
	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			points[0].initialize();
			System.out.println("Halbachse a: ");
			a = Help.Input.nextDouble();
			System.out.println("Halbachse b: ");
			b = Help.Input.nextDouble();
		
		}while(!isValid());
	}
	@Override
	public double calculatePerimeter() {
		return Math.PI*(3*(a+b) - Math.sqrt((3*a + b)*(a + 3*b)));
	}
	@Override
	public double calculateArea() {
		return Math.PI*a*b;
	}
	@Override
	public String getType() {
		return(a==b) ? "Kreis" : "Ellipse";
	}
	@Override
	public String toString() {
		return points[0] + "-[" + a + "," + b + "}";
	}
	
	/*public void print() {
		double perimeter = calculatePerimeter();
		System.out.format("%s, %s, U=%s, F=%s\n", this, getType(), perimeter, calculateArea());
	}*/
	@Override
	public boolean equal(/*Eclipse otherRectangle*/ GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Eclipse) {
		Eclipse otherEclipse = (Eclipse) otherGeometricObject;
		boolean sameHeight = Help.equal(a,  otherEclipse.a);
		boolean sameWidth = Help.equal(b,  otherEclipse.b);
		boolean sameHeightReversed = Help.equal(a,  otherEclipse.b);
		boolean sameWidthReversed = Help.equal(b,  otherEclipse.a);
		
		return (sameHeight && sameWidth) || (sameHeightReversed && sameWidthReversed);}
		else {
			return false;
		}
	}
	@Override
	public Shape createShape(int scale) {
		double scaledCenterX = (points[0].x +a) * scale;
		double scaledCenterY = (points[0].y + b) * scale;
		double scaledA = a * scale;
		double scaledB = b * scale;
		return new javafx.scene.shape.Ellipse(scaledCenterX, scaledCenterY, scaledA, scaledB);
	}
}
