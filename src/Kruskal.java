import java.util.LinkedList;
import java.util.List;

public class Kruskal { 
	static public int QUICKSORT = 1;
	static public int HEAP = 2;
	static public int RADIXSORT = 3;
	static public int VEB = 4;
  
	private Edge edges[];
	private int N;
	private Iterable q;
	
    public Kruskal(Edge[] edges, int N, int sortMethod){
    	this.edges = edges;
    	this.N = N;
    	
    	if(sortMethod == QUICKSORT)
    		q = new QuickSort(edges);
    	else if(sortMethod == HEAP)
    		q = new FixedHeap(edges);
    	else if(sortMethod == RADIXSORT)
    		q = new RadixSort(edges, 7);
    	else if(sortMethod == VEB){
    		q = new IterableVEB(edges);
    		System.out.println("vEB initialized");
    	}
    	else
    		q = new QuickSort(edges);
    }
          
	public List<Edge> compute(){
		UnionFind u= new UnionFind(N);
		List<Edge> MST = new LinkedList<Edge>();
		
		int s, e;
		int E = edges.length;
		Edge n;
		for (int i=0; i<E;i++){
			n = q.getNext();
			s = n.getStartNode();
			e = n.getEndNode();
			if(u.findWO(s)!=u.findWO(e)){
				u.union(s,e);
				MST.add(n);
			}
				
		}
		return MST;
  
    }   
} 