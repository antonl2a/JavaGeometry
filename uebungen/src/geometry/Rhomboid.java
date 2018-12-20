package geometry;

import javafx.scene.shape.Shape;

public class Rhomboid extends GeometricObject {
	
	private double a;
	private double b;
	private Quadrangle quadrangle;

	protected Rhomboid() {
		super("Rhomboid", 1, 0);
		points[0] = new Point(0,0);
		this.a = 1;
		this.b = 1;
	    calculateFigures();
	}
	
	public Rhomboid(Point point, double a, double b) {
		super("Rhomboid", 1, 0);
		points[0] = new Point(point);
		this.a = a;
		this.b = b;
	    calculateFigures();
	}
	
	public Rhomboid(Rhomboid rhomboid) {
		super("Rhomboid", 1, 0);
		points[0] = new Point(rhomboid.points[0]);
		this.a = rhomboid.a;
		this.b = rhomboid.b;
	    calculateFigures();
	}
	
	private void calculateFigures() {
		Point p1 = new Point(points[0].x + a/2, points[0].y);
		Point p2 = new Point(points[0].x +a, points[0].y + b/2);
		Point p3 = new Point(points[0].x +a/2, points[0].y +b);
		Point p4 = new Point(points[0].x, points[0].y + b/2);
		quadrangle = new Quadrangle(p1,p2,p3,p4);
	}

	@Override
	public Shape createShape(int scale) {
		return quadrangle.createShape(scale);
	}

	@Override
	public boolean contains(double x, double y) {
	    return quadrangle.contains(x, y);
	}

	@Override
	public boolean isValid() {
		return a>0 && b>0;
	}

	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			points[0].initialize();
			System.out.println("a: ");
			a = Help.Input.nextDouble();
			System.out.println("b: ");
			b = Help.Input.nextDouble();
		
		}while(!isValid());
		calculateFigures();
		
	}

	@Override
	public double calculatePerimeter() {
		return quadrangle.calculatePerimeter();
	}

	@Override
	public double calculateArea() {
		return quadrangle.calculateArea();
	}

	@Override
	public String getType() {		
		return (a==b) ? "Rhombus" : "Rhomboid";
	}

	@Override
	public String toString() {
		return String.format("(%s, %s) - {%s, %s}", points[0].x , points[0].y , a, b);
	}

	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Rhomboid) {
			Rhomboid otherRhomboid = (Rhomboid) otherGeometricObject;
			return Help.equal(a, otherRhomboid.a) && Help.equal(b,  otherRhomboid.b);
		}
			else {
		return false;
			}
	}


}
