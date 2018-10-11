package uebung3;
import java.util.Scanner;
public class DreieckBerechnung {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		
		do {
		if((a>0 && b>0 && c>0)&&((a+b>c)||(b+c>a)||(a+c>b)))
		{
			double p= (a+b+c)/2;
			double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
			System.out.println(area);
			if(a==b&&a==c&&b==c){
				System.out.println("gleichseitig");
				
			}else if(a==b||a==c||b==c) {
				System.out.println("gleichschenklig");
				
			}else {
				System.out.println("ungleichseitig");
			}
		}else {
			System.out.println("Inkorrekte Werte");
		}
		}while(a>0 && b>0 && c>0);
		
		
		
				
	}

}
