import java.util.LinkedList;
import java.util.List;

public class Kruskal { 
  
	private Edge edges[];
	private int N;
    public Kruskal(Edge[] edges, int N){
    	this.edges = edges;
    	this.N = N;
    }
          
	public List<Edge> compute(){
    	UnionFind u = new UnionFind(N);
        QuickSort.sort(edges);
		List<Edge> MST = new LinkedList<Edge>();
		int s, e;
		int E = edges.length;
		Edge n;
		for (int i=0; i<E;i++){
			n=edges[i];
			s=n.getStartNode();
			e=n.getEndNode();
			if(u.find(s)!=u.find(e)){
				u.union(s,e);
				MST.add(n);
			}
				
		}
		return MST;
  
    }   
} 