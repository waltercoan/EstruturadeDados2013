package recursao;

import java.util.Scanner;

public class FibonacciRecursivo {
	public static int fibonacci(int n){
		if(n<=1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2); 
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite qual número fibonacci deseja gerar");
		int n = Integer.parseInt(s.nextLine());
		int f = fibonacci(n);
		System.out.println(String.format("Fibonacci: %d\n", f));
	}
}
