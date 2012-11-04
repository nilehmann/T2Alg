
public class IterableVEB implements Iterable{
	Hash h;
	VanEmdeBoas vEB;
	private int current;
	private int M;
	
	public IterableVEB(Edge[] edges, int M){
		this.M = M;
		current = -1;
		h = new Hash(M,10);
		
		vEB = new VanEmdeBoas(M*10);
		for(Edge e : edges)
			vEB.insert(h.add(e.getDistance(), e));
	}
	
	@Override
	public Edge getNext(){
		current = vEB.findNext(current);
		if(current == M)
			return null;
		return h.get(current);
			
	}
}
