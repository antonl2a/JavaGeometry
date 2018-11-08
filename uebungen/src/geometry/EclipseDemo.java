package geometry;

public class EclipseDemo {
	public static void main(String[] args) {
		Eclipse eclipse1 = new Eclipse();
		Point startPoint3= new Point(1,1);
		Eclipse eclipse2 = new Eclipse(startPoint3,5,6);
		Eclipse eclipse3 = new Eclipse(eclipse2);
		Eclipse eclipse4 = new Eclipse();
		eclipse4.initialize();
		
		eclipse1.print();
		eclipse2.print();
		eclipse3.print();
		eclipse4.print();
		System.out.println("Recteck 2 gleich Rechteck 1: " + eclipse2.equal(eclipse1));
		System.out.println("Rechteck 2 gleich Rechteck 3: " + eclipse2.equal(eclipse3));
	}
}
