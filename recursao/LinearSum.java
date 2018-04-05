package recursao;
public class LinearSum {
    public static int calcLinearSum(int[] a, int num){
        if (num == 1){
            return a[0];
        }else{
            return calcLinearSum(a,num-1) + a[num-1];
        }
    }
    public static void main(String[] args) {
        int numeros[] = {20,45,07,15,32,03,22,10};
        System.out.println(LinearSum.calcLinearSum(numeros, 5));
    }
}
