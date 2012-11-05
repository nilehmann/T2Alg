
public class IterableVEB implements Iterable{
	Hash h;
	VanEmdeBoas vEB;
	private int current;
	private int M;
	
	public IterableVEB(Edge[] edges){
		M = 6300000;
		current = -1;
		h = new Hash(420000,15);
		
		vEB = new VanEmdeBoas(M);
		for(Edge e : edges)
			vEB.insert(h.add(e.getDistance(), e));
	}
	
	@Override
	public Edge getNext(){
		int ant = current;
		current = vEB.findNext(current+1);
		if(ant > current)
			System.out.println("Problemas");
		if(current == M)
			return null;
		return h.get(current);
			
	}
}
