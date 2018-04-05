package carla;

import fila.LinkedListQueue;
import fila.Queue;

public class GerenciadorImpressao {

	private Queue<impressao> filaPrioridadeAlta = new LinkedListQueue<impressao>();
	private Queue<impressao> filaPrioridadeBaixa = new LinkedListQueue<impressao>();
	private Queue<impressao> filaImpressao = new LinkedListQueue<impressao>();
	private Queue<impressao> filaEntradaImpressao = new LinkedListQueue<impressao>();

	public void novoPedidoImpressao(impressao imp) {
		filaEntradaImpressao.enqueue(imp);

	}

	public void organizarPedidosImpressao() {
		impressao imp = null;
		while (!filaEntradaImpressao.isEmpty()) {
			imp = filaEntradaImpressao.dequeue();
			if (imp.getPrioridade() <= 2) {
				filaPrioridadeAlta.enqueue(imp);
				//filaEntradaImpressao.front();
				// front(): Retorna, mas não remove, o objeto na frente da fila.
				// Ocorre um erro se a fila estiver vazia.

			} else {
				if (imp.getPrioridade() > 2 && imp.getPrioridade() < 5) {
					filaPrioridadeBaixa.enqueue(imp);
					//filaEntradaImpressao.dequeue();
				} else {
					if (imp.getPrioridade() > 4) {
						//filaEntradaImpressao.dequeue();
						System.out.println(" IMPRESSAO EXCLUIDA - USUARIO"
								+ imp.getUsuario() + " Prioridade "
								+ imp.getPrioridade());

					}
				}
			}
			// System.out.println("Impressoes"+" USUARIO "
			// +imp.getUsuario()+" NUMERO "
			// +imp.getNumero()+" PRIORIDADE "+imp.getPrioridade()+" TAMANHO "+imp.getTamanho());
		}
		while (!filaPrioridadeAlta.isEmpty()) {
			filaImpressao.enqueue(filaPrioridadeAlta.dequeue());
		}
		while (!filaPrioridadeBaixa.isEmpty()) {
			filaImpressao.enqueue(filaPrioridadeBaixa.dequeue());

		}
	}

	public void listarImpressoes() {
		impressao impre = null;
		while (!filaImpressao.isEmpty()) {
			impre = filaImpressao.dequeue();
			System.out.println("Listar impressões");
			System.out.println("Numero" + impre.getNumero());
			System.out.println("Prioridade" + impre.getPrioridade());
			System.out.println("Tamanho:" + impre.getTamanho());
			System.out.println("Usuario:" + impre.getUsuario());
		}
	}

	public static void main(String[] args) {
		GerenciadorImpressao sistema = new GerenciadorImpressao();

		impressao imp1 = new impressao(11, 123, "Maria", 4);
		impressao imp2 = new impressao(12, 435, "José", 3);
		impressao imp3 = new impressao(13, 734, "Pedro", 1);
		impressao imp4 = new impressao(14, 246, "Zezinho", 5);
		impressao imp5 = new impressao(15, 126, "José", 2);
		impressao imp6 = new impressao(16, 964, "Pedro", 1);

		sistema.novoPedidoImpressao(imp1);
		sistema.novoPedidoImpressao(imp2);
		sistema.novoPedidoImpressao(imp3);
		sistema.novoPedidoImpressao(imp4);
		sistema.novoPedidoImpressao(imp5);
		sistema.novoPedidoImpressao(imp6);

		
		sistema.organizarPedidosImpressao();
		sistema.listarImpressoes();
	}
}
