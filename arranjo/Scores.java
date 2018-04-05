package arranjo;

public class Scores {
	public static final int maxEntries = 10;
	protected int numEntries;
	protected GameEntry[] entries;
	
	public Scores() {
		entries = new GameEntry[maxEntries];
		numEntries = 0;
	}
	public void add(GameEntry e){
	    int newScore = e.getScore();
	    if (numEntries == maxEntries){ // verifica se esta cheio
	        if (newScore <= entries[numEntries - 1].getScore())
	            return;
	    }else
	    	numEntries++;
	    int i = numEntries - 1;
	    for(;(i>=1) && (newScore > entries[i-1].getScore()); i--)
	        entries[i]=entries[i-1];
	    entries[i]=e;
	}
	public GameEntry remove(int i) throws IndexOutOfBoundsException{
	    if ((i<0) || (i >= numEntries))
	       throw new IndexOutOfBoundsException("Invalid index: " + i);
	    GameEntry temp = entries[i];
	    for (int j = i; j<numEntries -1; j++)
	        entries[j] = entries[j+1];
	    entries[numEntries - 1] = null;
	    numEntries--;
	    return temp;
	}

	public void insertionSort(GameEntry[] novo){
		for(int i=1; i < novo.length; i++ ){
			if(novo[i].getScore() > novo[i-1].getScore()){
				for(int j = i; j  > 0 ; j--){
					if(novo[j].getScore() > novo[j-1].getScore()){
						GameEntry aux = novo[j-1];
						novo[j-1] = novo[j];
						novo[j] = aux;
					}else{
						break;
					}
				}
			}
		}
		
		entries = novo;
		//maxEntries = novo.length;
		numEntries = novo.length;
		
	}
	
	
	public static void main(String[] args) {
		Scores placar = new Scores();
		/*
		placar.add(new GameEntry("Jill",740));
		placar.add(new GameEntry("Walter",1000));
		placar.add(new GameEntry("Romao",500));
		placar.add(new GameEntry("Dornel",50));*/
		
		GameEntry[] bagunca = {new GameEntry("a",10),
								new GameEntry("b",1),
								new GameEntry("c",5),
								new GameEntry("d",7) };
		
		placar.insertionSort(bagunca);
		
		System.out.println(placar);
		
		
		
	}
	public String toString(){
		String s = "[";
		for(int i=0; i<numEntries; i++){
			if(i>0) s += ", ";
			s += entries[i];
		}
		return s + "]";
	}
	

}
