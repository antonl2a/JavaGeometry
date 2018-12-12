package JavaBook;
import java.util.Scanner;
public class DisplayUniCode {
	public static void main(String[] args) {
		sum(2,6);
		System.out.println(sum(2,6));
	}
	public static int sum(int i1, int i2) {
		int result = 0;
		for (int i = i1; i <= i2; i++) {
			result +=i;
		}
		return result;
	}
	public static void xMethod(double x, double y) {
		System.out.println(x+y);
		
	}
}

