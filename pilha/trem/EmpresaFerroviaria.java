package pilha.trem;

import pilha.SLinkedListStack;
import pilha.Stack;

public class EmpresaFerroviaria {
	Stack<Vagao> pilhaA = new SLinkedListStack<Vagao>();
	Stack<Vagao> pilhaB = new SLinkedListStack<Vagao>();
	Stack<Vagao> pilhaS = new SLinkedListStack<Vagao>();
	
	public void inserirVagLinhaA(Vagao umVagao){
		pilhaA.push(umVagao);
	}
	public void ordenarVagoes(){
		while(!pilhaA.isEmpty()){
			Vagao umVagao = pilhaA.pop();
			if(pilhaS.isEmpty()){
				pilhaS.push(umVagao);
			}else{
				Vagao vagaoPonta = pilhaS.top();
				if(umVagao.getPeso() > vagaoPonta.getPeso()){
					//ordenar...
					while(!pilhaS.isEmpty() && pilhaS.top().getPeso()<
							umVagao.getPeso()){
						pilhaB.push(pilhaS.pop());
					}
					pilhaS.push(umVagao);
					while(!pilhaB.isEmpty()){
						pilhaS.push(pilhaB.pop());
					}
				}else{
					pilhaS.push(umVagao);
				}
			}
		}
	}
	public void lista(){
		while(!pilhaS.isEmpty()){
			Vagao v = pilhaS.pop();
			System.out.println("Peso: " + v.getPeso());
		}
	}
	
	public static void main(String[] args) {
		EmpresaFerroviaria ef = new EmpresaFerroviaria();
		
		ef.inserirVagLinhaA(new Vagao(100));
		ef.inserirVagLinhaA(new Vagao(350));
		ef.inserirVagLinhaA(new Vagao(120));
		ef.inserirVagLinhaA(new Vagao(600));
		ef.inserirVagLinhaA(new Vagao(1500));
		ef.inserirVagLinhaA(new Vagao(250));
		ef.inserirVagLinhaA(new Vagao(80));
		ef.inserirVagLinhaA(new Vagao(900));
		
		ef.ordenarVagoes();
		ef.lista();
	}
}
