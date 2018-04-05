package recursao;

public class SomaDigitos {

	/**
	 * @param args
	 */
	
	
	public static int soma(int numero){
		int div = numero / 10;
		int resto = numero % 10;
		
		if(div != 0)
			return resto + soma(div);
		else
			return resto ;
	}
	
	public static void main(String[] args) {
		int soma = SomaDigitos.soma(2345);
		System.out.println("Resultado " + soma);

	}

}
