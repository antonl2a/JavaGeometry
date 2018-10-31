package geometry;
import java.util.Scanner;
public class Help {
	public static final Scanner Input= new Scanner(System.in);
	public static final double razlika=0.0001;
	
	public static boolean equal(double x, double y) {
		return Math.abs(x-y)<razlika;
	}

}
