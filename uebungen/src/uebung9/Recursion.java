package uebung9;

public class Recursion {
	public static void main(String[] args) {
		System.out.println("Factorial: " + factorial(5));
		System.out.println("Factorial recursive: "+ factorialRecursive(5));
		System.out.println("Fibonacci: "+ fibonacci(2));
		System.out.println("Fibonacci recursive: " + fibonacciRecursive(12));
		
	}
	private static int factorial(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result+=i;
		}
		return result;
	}
	private static int factorialRecursive(int n) {
		if(n<2)
		{
			return 1;
		}
		else 
		{
			return n+factorialRecursive(n-1);
		}
	}
	private static int fibonacci(int n) {
		int firstNumber = 0;
		int secondNumber = 1;
		while (n>1) {
			secondNumber = firstNumber + secondNumber;
			firstNumber = secondNumber - firstNumber;
			n--;			
		}
		return firstNumber;
	}
	private static int fibonacciRecursive(int n) {
		if(n<=1) {
			return 0;
		}
		else if(n==2) {
			return 1;
		}
		else {
			return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
		}
	}
}
