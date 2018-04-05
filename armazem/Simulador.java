package armazem;

import pilha.ArrayStack;
import pilha.SLinkedListStack;
import pilha.Stack;

public class Simulador {
	
	//ArrayStack<E>
	Stack<Produto> pilhaEntrada =
			new ArrayStack<Produto>();
	
	Stack<Produto> pilha1 =
			new ArrayStack<Produto>();
	
	Stack<Produto> pilha2 =
			new SLinkedListStack<Produto>();	
	
	public void receberProdutos(Produto umProduto){
		pilhaEntrada.push(umProduto);
	}
	public void organizarProdutos(){
		while(!pilhaEntrada.isEmpty()){
			Produto umProduto = pilhaEntrada.pop();
			if(umProduto.getCategoria() == 1){
				pilha1.push(umProduto);
			}else{
				pilha2.push(umProduto);
			}
		}
	}
	public void imprimir(){
		int numPilha1 = pilha1.size();
		System.out.println(numPilha1 + 
				" Produtos Categoria 1");
		while(!pilha1.isEmpty()){
			Produto umProduto = pilha1.pop();
			System.out.println("Produto:"+
					umProduto.getDescricao() +
					"\t|\t" +
					umProduto.getPeso()+
					"Kg");
		}
		System.out.println("\n\n\n");
		
		int numPilha2 = pilha2.size();
		System.out.println(numPilha2 + 
				" Produtos Categoria 2");
		while(!pilha2.isEmpty()){
			Produto umProduto = pilha2.pop();
			System.out.println("Produto: " +
					umProduto.getDescricao()+
					"\t|\t"+
					umProduto.getPeso()+
					"Kg");
		}
	}
	public static void main(String[] args) {
		Simulador sim = new Simulador();
		sim.receberProdutos(new Produto("Ar con", 1, 26));
		sim.receberProdutos(new Produto("Refri Dup", 2, 91));
		sim.receberProdutos(new Produto("Lava Louc", 1, 19));
		sim.receberProdutos(new Produto("Freezer", 2, 92));
		sim.receberProdutos(new Produto("Lavadora", 1, 29));
		sim.organizarProdutos();
		sim.imprimir();
		
	}
	
	
}
