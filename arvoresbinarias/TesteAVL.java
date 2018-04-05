package arvoresbinarias;

public class TesteAVL {
	public static void main(String[] args) {
		LinkedBinaryTree<Integer> arvoreAVLBinaria = 
				new LinkedBinaryTree<Integer>();
		int seq[] = {41,38,31,12,19,8,27,49};
		
		for(int s:seq){
			arvoreAVLBinaria.insertNode(s);
		}
		//arvoreAVLBinaria.preordem(arvoreAVLBinaria.root());
		//arvoreAVLBinaria.posordem(arvoreAVLBinaria.root());
		
		arvoreAVLBinaria.search(49);
		System.out.println(arvoreAVLBinaria.searchDeepth);
		
	}
}
