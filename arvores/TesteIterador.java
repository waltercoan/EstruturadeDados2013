package arvores;

import java.util.ArrayList;

public class TesteIterador {
	public static void main(String[] args) {
		ArrayList<String> palavras = new ArrayList<String>();
		palavras.add("Ola");
		palavras.add("Mundo");
		palavras.add("da");
		palavras.add("Univille");
		for(String p:palavras){
			System.out.println(p);
		}
	} 
	
}
