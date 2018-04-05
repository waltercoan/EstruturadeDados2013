package pilha;

public class ValidaEquacao {

	public static boolean validar(String eq){

		ArrayStack<Character> pilha = new ArrayStack<Character>();
		try{
			for(char umCaracter:eq.toCharArray()){
				if(isOpen(umCaracter)){
					pilha.push(umCaracter);
				}else{
					if(isClose(umCaracter)){
						char charTopo = pilha.pop();
						if(!matchs(charTopo,umCaracter)){
							return false;
						}
					}
				}
				System.out.println(umCaracter);
			}
		}catch(EmptyStackException e){
			return false;
		}
		//aquiiii ooohh
		if(!pilha.isEmpty())
			return false;

		return true;
	}
	private static boolean matchs(char open, char close) {
		return ((open == '(' & close == ')') |
				(open == '{' & close == '}') |
				(open == '[' & close == ']'));
	}
	private static boolean isClose(char umC) {
		return (umC == ')' | umC == '}' | umC == ']');
	}
	private static boolean isOpen(char umC) {
		return (umC == '(' | umC == '{' | umC == '[');
	}
	public static void main(String[] args) {
		boolean resp =
				ValidaEquacao.validar("2+4)-7]*2}");
		System.out.println((resp?"Valido":"Não valido"));
	}

}
