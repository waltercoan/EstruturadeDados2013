package recursao;

import java.util.Scanner;

public class FibonacciIterativo {
	public static int fibonacci(int n){
		int fib=0, ult=0, pen=0;
		for(int i=0;i<=n;i++){
			if(i == 0){
				ult=0;
				pen = 0;
				fib = 0;
			}else{
				if(i == 1){
					pen = ult;
					ult = fib;
					fib = 1;
				}else{
					pen = ult;
					ult = fib;
					fib = ult + pen;
				}
			}
		}
		return fib;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite qual número fibonacci deseja gerar");
		int n = Integer.parseInt(s.nextLine());
		int f = fibonacci(n);
		System.out.println(String.format("Fibonacci: %d\n", f));
	}
}
