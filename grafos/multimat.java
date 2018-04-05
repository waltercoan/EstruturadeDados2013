package grafos;

public class multimat {
	public static void main(String[] args) {
		int a[][] = {{1,2},{3,4}};
		int b[][] = {{4,3},{2,1}};
		int r[][] = new int[2][2];
		int l=0, c=0, k=0;
		
		for(l=0;l<2;l++){
			for(c=0;c<2;c++){
				for(k=0;k<2;k++){
					r[l][c] += a[l][k] * b[k][c];
				}
			}
		}
		for(l=0;l<2;l++){
			for(c=0;c<2;c++){
				System.out.print(String.format("%d ", r[l][c]));
			}
			System.out.println();
		}
		 	
	}
}
