package arvoresbinarias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IndexarBiblia {
	public static void main(String[] args) {
		LinkedBinaryTree<String> bible = new LinkedBinaryTree<String>();
		Scanner entrada = new Scanner(System.in);
		
		try {
			Scanner leitor = new Scanner(
					new File(
							ClassLoader.getSystemResource("arvoresbinarias/Genesis.txt").getFile()));
			
			String palavra=null;
			System.out.println("Carregando");
			while((palavra=leitor.next())!=null){
				bible.insertNode(palavra);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e){}
		System.out.println("Fim da carga");
		while(true){
			System.out.println("Digite valor busca");
			String busca = entrada.nextLine();
			boolean r = bible.search(busca);
			System.out.println(r);
			System.out.println("searchDeepth " + bible.searchDeepth);
		}	
		
	}
	
}
