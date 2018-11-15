package uebung4;
import java.util.Scanner;
public class Numbers {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
	System.out.println("1234 palindromisch: "+ isPalindrome(1234));
	System.out.println("1221 palindromisch: "+ isPalindrome(1221));
	System.out.println("1234 umgekehrt: "+reverse(1234));
	System.out.println("127 Primzahl: "+ isPrime(127));
	System.out.println("1234 Primzahl: "+isPrime(1234));
	
	}
	public static int reverse(int number) {
		String sum="";
		String numberString=""+number;
		for(int i=numberString.length()-1;i>=0;i--) {
			sum+=numberString.charAt(i);
			
		}
		return Integer.parseInt(sum);
	}
	public static boolean isPalindrome(int number) {
		int reversedNumber=reverse(number);
		return reversedNumber==number;
	}
	private static boolean isPrime(int number) {
		int divider=2;
		while(divider<=Math.sqrt(number)) {
			if(number%divider==0) {
				return false;
			}
			divider++;
		}
		return true;
	}

}
