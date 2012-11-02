import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Prim {
	private List<Pair> graph[];
	private List<Edge> edges;
	private PriorityQueue queue;
	private int N;
	
	public Prim(List<Pair> graph[], int N){
		this.graph = graph;
		this.N = N;
		queue = new Heap(N);
	}
	
	public List<Edge> compute(int w){
		int node[] = new int[N+1];
		
		for (int i = 0; i <= N; i++) 
			node[i] = -2;
		
		List<Edge> MST = new LinkedList<Edge>();
		queue.clear();
		edges = new ArrayList<Edge>();
		int count = 0;
		for(Pair v : graph[w]){
			queue.offer(count, v.second);
			edges.add(new Edge(count, w, v.first, v.second));
			node[v.first] = count++;
		}
		
		while(queue.size() > 0){
			Pair edge = queue.poll();
			MST.add(edges.get(edge.first));
			node[edges.get(edge.first).getStartNode()] = -1;
			int u = edges.get(edge.first).getEndNode();
			
			for(Pair v : graph[u]){
				if(node[v.first] == -2){
					Edge e = new Edge(count, u, v.first, v.second);
					node[v.first] = count; 
					queue.offer(count++, v.second);
					edges.add(e);
				}
				else if(node[v.first] != -1){
					Edge e = edges.get(node[v.first]);
					if(v.second < e.getDistance()){
						edges.set(e.getID(), new Edge(e.getID(), u, v.first, v.second));
						queue.update(e.getID(), v.second);
					}
				}
			}
			
		}
		return MST;
		
	}
}
