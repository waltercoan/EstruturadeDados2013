package filavoo;

import fila.LinkedListQueue;
import fila.Queue;

public class SistemaControle {
	private Queue<Voo> filaChegada = new LinkedListQueue<Voo>();
	private Queue<Voo> filaSaida = new LinkedListQueue<Voo>();
	private Queue<Voo> filaPista = new LinkedListQueue<Voo>();
	
	public void agendarChegada(Voo voo){
		filaChegada.enqueue(voo);
	}
	public void agendaSaida(Voo voo){
		filaSaida.enqueue(voo);
	}
	public void organizarVoos(){
		Voo vooChegada = null, vooSaida = null;
		Voo vooAlocado;
		
		while(!filaChegada.isEmpty() || !filaSaida.isEmpty()){
			if(vooChegada == null && !filaChegada.isEmpty())
				vooChegada = filaChegada.dequeue();
			
			
			
			if(vooSaida == null && !filaSaida.isEmpty())
				vooSaida = filaSaida.dequeue();
			
			
			
			
			if(vooChegada.getHoraChegada() >
					vooSaida.getHoraSaida()){
				vooAlocado = vooSaida;
				vooSaida = null;
			}else{
				if(vooChegada.getHoraChegada() <
						vooSaida.getHoraSaida()){
					vooAlocado = vooChegada;
					vooChegada = null;
				}else{
					vooAlocado = vooChegada;
					vooChegada = null;
					System.out.println("Voo Cancelado...");
					System.out.println("Hora Saida:" + vooSaida.getHoraSaida());
					System.out.println("Hora Chegada:" + vooSaida.getHoraChegada());
					System.out.println("Origem:" + vooSaida.getOrigem());
					System.out.println("Destino:" + vooSaida.getDestino());
					vooSaida = null;
				}
			}
			filaPista.enqueue(vooAlocado);
			
			
		}
		//este método deverá ler as filas de voos 
		//de chegada e partida (priorizando as chegadas) 
		//e mover os voos para uma fila chamada de 
		//alocação da pista. Caso exista conflito 
		//de horário entre voos, o menos prioritário 
		//devem ser descartados e seus dados apresentados 
		//em tela.
	}
	public void listar(){
		System.out.println("\nListagem de alocação da pista\n");
		while(!filaPista.isEmpty()){
			Voo voo = filaPista.dequeue();
			System.out.println("Hora Saida:" + voo.getHoraSaida());
			System.out.println("Hora Chegada:" + voo.getHoraChegada());
			System.out.println("Origem:" + voo.getOrigem());
			System.out.println("Destino:" + voo.getDestino());
		}
	}
	public static void main(String[] args) {
		SistemaControle sistema = new SistemaControle();
		
		Voo voo1 = new Voo(6,5,"Joinville", "São Paulo");
		Voo voo2 = new Voo(7,22,"Lisboa", "São Paulo");
		Voo voo3 = new Voo(10,8,"São Paulo", "Salvador");
		Voo voo4 = new Voo(9,7,"Porto Alegre", "São Paulo");
		Voo voo5 = new Voo(11,9,"São Paulo", "Porto Alegre");
		
		sistema.agendarChegada(voo1);
		sistema.agendarChegada(voo2);
		sistema.agendaSaida(voo3);
		sistema.agendarChegada(voo4);
		sistema.agendaSaida(voo5);

		sistema.organizarVoos();
		
		sistema.listar();
		
	}
}
