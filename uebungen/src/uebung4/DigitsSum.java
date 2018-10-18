package uebung4;
import java.util.Scanner;

public class DigitsSum {
	public static void main(String[] args) {
		int num1=sumNum(1234);
		int num2=sumNum(567);
		int year=sumNum(2018);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(year);
		
	}
	public static int sumNum(int num) {
		int sum=0;
		while(num>0) {
			sum+=num%10;
			num/=10;
			
		}
		return sum;
	}

}
