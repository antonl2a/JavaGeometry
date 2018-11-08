package geometry;

public class Eclipse {
	private Point startPoint;
	private double a;
	private double b;
	
	public Eclipse() {
		startPoint = new Point(0, 0);
		a = 1;
		b = 1;
	}
	
	public Eclipse(Point startPoint, double height, double width) {
		this.startPoint = new Point(startPoint);
		this.a = height;
		this.b = width;
	}
	
	public Eclipse(Eclipse otherEclipse) {
		startPoint = new Point(otherEclipse.startPoint);
		a = otherEclipse.a;
		b = otherEclipse.b;
	}
	public boolean isValid() {
		return a > 0 && b > 0;
	}
	
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			startPoint.initialize();
			System.out.println("Halbachse a: ");
			a = Help.Input.nextDouble();
			System.out.println("Halbachse b: ");
			b = Help.Input.nextDouble();
		
		}while(!isValid());
	}
	
	public double calculatePerimeter() {
		return Math.PI*(3*(a+b) - Math.sqrt((3*a + b)*(a + 3*b)));
	}
	
	public double calculateArea() {
		return Math.PI*a*b;
	}
	
	public String getType() {
		return(a==b) ? "Kreis" : "Ellipse";
	}
	public String toString() {
		return startPoint + "-[" + a + "," + b + "}";
	}
	
	public void print() {
		double perimeter = calculatePerimeter();
		System.out.format("%s, %s, U=%s, F=%s\n", this, getType(), perimeter, calculateArea());
	}
	
	public boolean equal(Eclipse otherRectangle) {
		boolean sameHeight = Help.equal(a,  otherRectangle.a);
		boolean sameWidth = Help.equal(b,  otherRectangle.b);
		boolean sameHeightReversed = Help.equal(a,  otherRectangle.b);
		boolean sameWidthReversed = Help.equal(b,  otherRectangle.a);
		
		return (sameHeight && sameWidth) || (sameHeightReversed && sameWidthReversed);
	}
}
