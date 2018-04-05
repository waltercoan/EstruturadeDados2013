package recursao;

public class ContaAteDez {
	public void contar(int i){
		i++;
		System.out.println(i);
		
		if(i <= 4)
			contar(i); //AQUI ESTA A RECURSAO...
		System.out.println("Voltando i" + i);
	}
	public static void main(String[] args) {
		ContaAteDez c = new ContaAteDez();
		c.contar(0);
	}
}
