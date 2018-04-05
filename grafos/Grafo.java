package grafos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fila.ArrayQueue;

public class Grafo {

	private int grafo[][];
	private int dimensao=0;
	private String vertices[];


	public void carregaGrafo(String arquivo){
		try {
			Scanner leitor = new Scanner(
					new File(
							ClassLoader.getSystemResource(arquivo).getFile()));

			int nlinha=0;

			while(leitor.hasNext()){
				String linha = leitor.nextLine();
				System.out.println(linha);

				if(nlinha == 0){
					dimensao = Integer.parseInt(linha);
					grafo = new int[dimensao][dimensao];
					vertices = new String[dimensao];
				}
				if(nlinha == 1){
					vertices = linha.split(" ");
				}
				if(nlinha > 1){
					int col=0;
					for(char celula:linha.toCharArray()){
						grafo[nlinha-2][col++] = celula - 48;
					}
				}
				nlinha++;
			}

			for(int lin=0;lin<dimensao;lin++){
				for(int col=0;col<dimensao;col++){
					System.out.print(grafo[lin][col] + " ");
				}
				System.out.println();
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void fechaTransit(){
		int fecha[][] = grafo.clone();
		for(int k=0;k<dimensao;k++){
			for(int i=0;i<dimensao;i++){
				if(fecha[i][k] != 0){
					for(int j=0;j<dimensao;j++){
						fecha[i][j] = 
								(fecha[i][j]==1) || (fecha[k][j]==1)?1:0;
					}
				}
			}
		}
		System.out.println("Fechamento Transitivo Warshall");
		for(int i=0;i<dimensao;i++){
			for(int j=0;j<dimensao;j++){
				System.out.print(fecha[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	private char color[];
	private int d[], f[];
	private String pi[];
	private int contador = 0;
	//private String vertices[];

	private void dfs(int inicio){
		color = new char[dimensao]; 
		d = new int[dimensao];
		f = new int[dimensao];
		pi = new String[dimensao];

		//	COMENTAR ESTA LINHA...
		//vertices = new String[]{"u","v","w","x","y","z"};

		contador = 0;
		//Branco - Cinza - Preto
		for(int i=0;i<dimensao;i++){
			color[i] = 'b';
			pi[i] = "/";
		}

		dfs_visit(inicio);

		for(int i=0;i<dimensao;i++){
			if(color[i] == 'b')
				dfs_visit(i);
		}
		for(int i=0;i<dimensao;i++){
			System.out.print(vertices[i] + "\t");
		}
		System.out.println();
		for(int i=0;i<dimensao;i++){
			System.out.print(d[i] + "\t");
		}
		System.out.println();
		for(int i=0;i<dimensao;i++){
			System.out.print(f[i] + "\t");
		}
		System.out.println();
		for(int i=0;i<dimensao;i++){
			System.out.print(color[i] + "\t");
		}
		System.out.println();
		for(int i=0;i<dimensao;i++){
			System.out.print(pi[i] + "\t");
		}

	}
	public boolean isConnected(int orig, int dest){
		return (grafo[orig][dest] == 1);
	}
	private void dfs_visit(int u){
		color[u] = 'c';
		System.out.println("-Cinza: " + vertices[u]);
		d[u] = ++contador;
		for(int v=0;v<dimensao;v++){
			if(isConnected(u, v)){
				System.out.println(vertices[v] + " cor: " + color[v]);
				if(color[v]=='b'){
					pi[v] = vertices[u];
					dfs_visit(v);
				}
			}
		}
		color[u] = 'p';
		System.out.println("+Preto: " + vertices[u]);
		f[u] = ++contador;
	}
	
	private void bfs(int inicio) throws Exception{
		ArrayQueue<Integer> fila = new ArrayQueue<Integer>();
//		vertices = new String[]{"u","v","w","x","y","z"};
		
		boolean [] visitados = new boolean[dimensao];
		fila.enqueue(inicio);
		visitados[inicio] = true;
		System.out.print("\nBreadth First Search iniciando no vertice: ");
		System.out.println(vertices[inicio]+" ");
		while(!fila.isEmpty()){
			int k = fila.dequeue();
			System.out.print(vertices[k]+" ");
			for(int i=0;i<dimensao;i++){
				if(isConnected(k,i) && !visitados[i]){
					fila.enqueue(i);
					visitados[i] = true;
				}
			}
		}
		System.out.println();
	}
	
	
	
	public void dijkstra(int origem, int destino){
		final int INFINITO = 9999;
		
		int dist[] = new int[dimensao];
		boolean perm[] = new boolean[dimensao];
		int caminho[] = new int[dimensao];
		
		for(int i=0;i<dimensao;i++){
			perm[i]= false;
			dist[i] = INFINITO;
			caminho[i] = -1;
		}
		
		perm[origem] = true;
		dist[origem] = 0;
		int corrente = origem;
		int k=corrente;
		char parar = 'N';
		int menordist = 0;
		
		while(corrente != destino && parar == 'N'){
			menordist = INFINITO;
			int dc = dist[corrente];
			int novadist = 0;
			for(int i = 0; i < dimensao; i++){
			    if(perm[i] == false){
					if (grafo[corrente][i] != 0)
					    novadist = dc + grafo[corrente][i];
					else
						novadist = INFINITO;
					if(novadist < dist[i]){
						dist[i] = novadist;
						caminho[i] = corrente;						
					}
					if(dist[i] < menordist){
						menordist = dist[i];
						k = i;
					}
				}
			}
			if(corrente == k){
				System.out.println("Caminho nao existe");
				parar = 'S';
			}else{
			    corrente = k;
			    perm[corrente] = true;
			}
		}
		int i = destino;
		vertices = new String[]{"u","v","w","x","y","z"};
		System.out.println("Algoritmo Dijkstra: menor caminho entre " + vertices[origem] + " ate " + vertices[destino]);
		System.out.print(vertices[destino] + " <- ");
		while(i != origem){
			System.out.print(vertices[caminho[i]] + " ");
			i = caminho[i];
	   	    if (i != origem)
	   	    	System.out.print(" <- ");
		}
		System.out.println("\n\nCusto: " + dist[destino]);
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Grafo g = new Grafo();
		g.carregaGrafo("grafos/grafo1.txt");
		//g.fechaTransit();
		
//		try {
//			g.bfs(2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		g.dijkstra(0, 4);
	}
}











