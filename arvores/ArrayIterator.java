package arvores;
import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E>{
    private E[] lista;
    private int numCursor;
    public ArrayIterator(E[] lista) {
        this.lista = lista;
    }
    public boolean hasNext() {
        if (numCursor < lista.length){
            return true;
        }else{
            numCursor = 0;
            return false;
        }
    }
    public E next() {
        Object toReturn = lista[numCursor];
        numCursor++;
        return (E)toReturn;
    }
    public void remove() {
        lista[numCursor-1] = null;
    }
    public static void main(String[] args) {
        String[] lista = {"Ana","Maria","Pedro","Joao"};
        ArrayIterator col = new ArrayIterator(lista);
        while(col.hasNext()){
            System.out.println(col.next());
        }
    }
}