package recursao;
import java.util.Arrays;
public class ReverseArray {
    public static void doReverseArray(int[] a, int ini, int end){
        if (ini < end){
            int aux = a[end-1];
            a[end-1] = a[ini-1];
            a[ini-1] = aux;
            doReverseArray(a, ini+1, end-1);
        }
    }
    public static void main(String[] args) {
        int a[] = {20,45,07,15,32,03,22,10};
        ReverseArray.doReverseArray(a, 3, 7);
        System.out.println(Arrays.toString(a));
    }
}
