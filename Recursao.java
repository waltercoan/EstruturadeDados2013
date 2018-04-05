
public class Recursao {
	public static void main(String[] args) {
		int[] a = {3,5,7,9,12,28};
		Recursao.searchBin(a, 0, 6, 12);
	}
	public static int searchBin (int[] a, int ini, int tam, int procurado) 
	{ 
		int meio;
		if (tam <= 0){ 
			return -1; 
		}else{ 
			meio = ini + tam/2; 
			if (procurado == a[meio]) 
				return meio; 
			else if (procurado < a[meio]) 
				return searchBin(a, ini, tam/2, procurado); 
			else 
				return searchBin(a, meio+1, (tam-1)/2, procurado); 
		} 
	}
}
