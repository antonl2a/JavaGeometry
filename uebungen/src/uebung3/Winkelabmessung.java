package uebung3;
import java.util.Scanner;
public class Winkelabmessung {
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		double winkel;
		char einheit;
		do {
			System.out.println("Winkeleingabe: ");
			winkel = input.nextDouble();
			System.out.println("Einheiteingabe: ");
			String symbole = input.next();
			einheit= symbole.charAt(0);
			
			if(einheit=='r') {
				double neuWinkel = winkel/Math.PI*180;
				System.out.println("Winkel: " + neuWinkel + "g");
			}else if(einheit=='g') {
				double neuWinkel= winkel*Math.PI/180;
				System.out.println("Winkel: "+neuWinkel+ "r");
			}
			
		}while(einheit=='g' || einheit=='r');
	}

}
