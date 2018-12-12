package geometry;

import java.awt.Polygon;

import javafx.scene.shape.Shape;

public class Triangle extends GeometricObject{
	/*private Point[] points = new Point[3];
	private double[] sides = new double[3];
	*/
	public Triangle() {
		super("Triangle",3,3);
		points[0] = new Point(0,0);
		points[1] = new Point(1,0);
		points[2] = new Point(0,1);
		calculateSides();
	}
	public Triangle(Point point1, Point point2, Point point3) {
		super("Triangle",3,3);
		points[0]= new Point(point1);
		points[1]= new Point(point2);
		points[2]= new Point(point3);
		calculateSides();
	}
	public Triangle ( Triangle otherTriangle) {
		super("Triangle",3,3);
		points[0]= new Point(otherTriangle.points[0]);
		points[1]= new Point(otherTriangle.points[1]);
		points[2]= new Point(otherTriangle.points[2]);
		sides[0] = otherTriangle.sides[0];
		sides[1] = otherTriangle.sides[1];
		sides[2] = otherTriangle.sides[2];
	}
	
	
	@Override
	public boolean isValid() {
		return !Help.areCollinear(points[0], points[1], points[2]);
	}
	@Override
	public void initialize() {
		do {
				points[0].initialize();
				points[1].initialize();
				points[2].initialize();
		}while(!isValid());
		calculateSides();
	}
	@Override
	public double calculatePerimeter() {
		
		return sides[0]+sides[1]+sides[2];
	}
	@Override
	public double calculateArea() {
		double p = (sides[0]+sides[1]+sides[2])/2;
		return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
	}
	
	public double getMaxAngle() {
		double alpha = Help.calculateAngle(sides[0],sides[2],sides[1]);
		double beta = Help.calculateAngle(sides[0],sides[1],sides[2]);
		double gamma = Help.calculateAngle(sides[1],sides[2],sides[0]);
		double maxAngle = Math.max(alpha, beta);
		return Math.max(maxAngle, gamma);
	}
	@Override
	public String getType() {
		String type;
		boolean firstSecondEqual = Help.equal(sides[0],sides[1]);
		boolean secondThirdEqual = Help.equal(sides[1],sides[2]);
		boolean firstThirdEqual = Help.equal(sides[0],sides[2]);
		if(firstSecondEqual&&secondThirdEqual) {
			type = "gleichseitig";
		}else if(firstSecondEqual || secondThirdEqual || firstThirdEqual) {
			type = "gleichschenklig";
		}else {
			type = "ungleichseitig";
		}
		double rightAngle=Math.PI/2;
		double maxAngle = getMaxAngle();
		if(Help.equal(maxAngle, rightAngle)) {
			type+= "rechtwinklig";
		}else if(maxAngle>rightAngle) {
			type+="stumpfwinklig";
		}else {
			type+="spitzwinkig";
		}
		return type;
	}
	@Override
	public String toString() {
		return points[0]+ "-" + points[1]+ "-" + points[2];
	}
	/*
	public void print() {
		System.out.format("%s, %s, U=%s, F=%s\n", this, getType(), calculatePerimeter(), calculateArea());
	}
	*/
	@Override
	public boolean equal(/*Triangle otherTriangle*/ GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Triangle) {
			Triangle otherTriangle = (Triangle) otherGeometricObject;
			double area = calculateArea();
			double otherArea = otherTriangle.calculateArea();
			return Help.equal(area, otherArea);
		}
		else {
			return false;
		}
		
	}
	@Override
	public Shape createShape(int scale) {
		double[] coordinates = {
				points[0].x, points[0].y,
				points[1].x, points[1].y,
				points[2].x, points[2].y
		};
		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i]*=scale;
		}
		return new javafx.scene.shape.Polygon(coordinates);
	}
	@Override
	public boolean contains(double x, double y) {
		Point clickPoint = new Point(x, y);
		Triangle triangle1 = new Triangle(points[0], points[1], clickPoint);
		Triangle triangle2 = new Triangle(points[1], points[2], clickPoint);
		Triangle triangle3 = new Triangle(points[2], points[0], clickPoint);
		double areaSum = triangle1.calculateArea() + triangle2.calculateArea() + triangle3.calculateArea();
		if (areaSum == calculateArea()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
