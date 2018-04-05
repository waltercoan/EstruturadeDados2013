public class BinarySum {
  public static int calcBinarySum(int[] a,int ini, int end){
      System.out.println("ini: " + ini + " end: " + end);
      if (end == 1){
          System.out.println("\tValor: " + a[ini]);
          return a[ini];
      }
      return BinarySum.calcBinarySum(a, ini, (end/2)) 
	         + 
	         BinarySum.calcBinarySum(a, ini + (end/2), (end/2)); 
  }
  public static void main(String[] args) {
    int numeros[] = {20,45,07,15,32};
    System.out.println(BinarySum.calcBinarySum(numeros,0,5));
  }
}
