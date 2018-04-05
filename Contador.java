
public class Contador {
	public static void main(String[] args) {
		
		int r = Contador.somamaisum(0);
		System.out.println(r);
	}
	
	public static int somamaisum(int base){
		
		//System.out.println(base);
		if(base < 5){
			return somamaisum(base + 1);
		}
		return base;
	}
}
