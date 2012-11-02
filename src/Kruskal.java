import java.util.LinkedList;
import java.util.List;

public class Kruskal { 
  
      
          
	public List<Edge> kruskal(int N, Edge[] edges){
    	UnionFind u= new UnionFind(N);
        QuickSort.sort(edges);
		List<Edge> MST = new LinkedList<Edge>();
		int s, e;
		int E=edges.length;
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