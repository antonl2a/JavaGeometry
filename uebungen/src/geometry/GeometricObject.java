package geometry;

public abstract class GeometricObject {
	protected String name;
	protected Point[] points;
	protected double[] sides;
	
	
	
	protected GeometricObject(String name, int pointsCount, int sidesCount) {
		this.name = name;
		points = new Point[pointsCount];
		sides = new double[sidesCount];
	}
	public abstract boolean isValid();
	public abstract void initialize();
	public abstract double calculatePerimeter();
	public abstract double calculateArea();
	public abstract String getType();
	public abstract String toString();
	public abstract boolean equal(GeometricObject otherGeometricObject);
	
	public void print() {
		System.out.printf("%s: %s, %s, %s, U=%s, F= %s\n", name,this,getType(),calculatePerimeter(),calculateArea());
	}
	protected void calculateSides() {
		for (int i = 0; i <points.length; i++) {
			int nextIndex = (i==points.length-1) ? 0 : i+1;
			sides[i] = Help.calculateDistance(points[i], points[nextIndex]);
		}
	}

}
