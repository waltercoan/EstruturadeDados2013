package fila;

public class Gerenciador {
	private Queue<Impressao> filaEntrada = 
			new LinkedListQueue<Impressao>();
	private Queue<Impressao> filaBaixa = 
			new LinkedListQueue<Impressao>();
	private Queue<Impressao> filaAlta = 
			new LinkedListQueue<Impressao>();
	private Queue<Impressao> filaImpressao= 
			new LinkedListQueue<Impressao>();
	
	
	public void novoPedidoImpressao(Impressao imp){
		filaEntrada.enqueue(imp);
	}
	public void organizarPedidosImpressao(){
		while(!filaEntrada.isEmpty()){
			Impressao umaImp = filaEntrada.dequeue();
			if(umaImp.getPrioridade() <= 2){
				filaAlta.enqueue(umaImp);
			}else{
				if(umaImp.getPrioridade() <= 4){
					filaBaixa.enqueue(umaImp);
				}else{
					System.out.println("Descartada");
					System.out.println("Numero" + umaImp.getNumero());
					System.out.println("Priori" + umaImp.getPrioridade());
					System.out.println("Tamanho" + umaImp.getTamanho());
					System.out.println("Usuario" + umaImp.getUsuario());
				}
			}
			//aqui1
		}
		while(!filaAlta.isEmpty()){
			filaImpressao.enqueue(filaAlta.dequeue());
		}
		while(!filaBaixa.isEmpty()){
			filaImpressao.enqueue(filaBaixa.dequeue());
		}
	}
	//aqui3
	public void listarImpressoes(){
		System.out.println("Listagem de impressões");
		while(!filaImpressao.isEmpty()){
			Impressao umaImp = filaImpressao.dequeue();
					
			System.out.println("Numero" + umaImp.getNumero());
			System.out.println("Priori" + umaImp.getPrioridade());
			System.out.println("Tamanho" + umaImp.getTamanho());
			System.out.println("Usuario" + umaImp.getUsuario());
		}
	}
	
	public static void main(String[] args) {
		Gerenciador g = new Gerenciador();
		g.novoPedidoImpressao(new Impressao(1, 123, "maria", 4));
		g.novoPedidoImpressao(new Impressao(2, 435, "jose", 3));
		g.novoPedidoImpressao(new Impressao(3, 734, "Pedro", 1));
		g.novoPedidoImpressao(new Impressao(4, 246, "zezinho", 5));
		g.novoPedidoImpressao(new Impressao(5, 126, "jose", 2));
		g.novoPedidoImpressao(new Impressao(6, 964, "Pedro", 1));

		g.organizarPedidosImpressao();
		
		g.listarImpressoes();
	}
	
}
