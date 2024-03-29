import java.util.LinkedList;
import java.util.List;


public class Prim {	
	static int HEAP = 1;
	static int TREAP = 2;
	static int ARRAY = 3;

	private List<Pair<Integer>> graph[];
	private PriorityQueue<Edge> queue;
	private int N;
	
	public Prim(List<Pair<Integer>> graph[], int N, int minMethod){
		this.graph = graph;
		this.N = N;
		
		if(minMethod == HEAP)
			queue = new Heap<Edge>(N);
		else if(minMethod == TREAP)
			queue = new Treap<Edge>(N);
		else if(minMethod == ARRAY)
			queue = new PriorityArray<Edge>(N);
		else
			queue = new Heap<Edge>(N);
		
	}
	
	public List<Edge> compute(int w){
		int node[] = new int[N+1];
		int nodeToEdge[] = new int[N+1];
		
		for (int i = 0; i <= N; i++)
			node[i] = -1;
		
		List<Edge> MST = new LinkedList<Edge>();
		queue.clear();
		int count = 0;
		node[w] = -1000;
		for(Pair<Integer> v : graph[w]){
			queue.offer(count, new Edge(count, w, v.first,  v.second));
			node[v.first] = v.second;
			nodeToEdge[v.first] = count++;
		}
		
		while(queue.size() > 0){
			Pair<Edge> edge = queue.poll();
			node[edge.second.getStartNode()] = -2;
			MST.add(edge.second);
			int u = edge.second.getEndNode();
			
			for(Pair<Integer> v : graph[u]){
				if(node[v.first] == -1){
					Edge e = new Edge(count, u, v.first,  v.second);
					node[v.first] = v.second; 
					nodeToEdge[v.first] = count;
					queue.offer(count++, e);
				}
				else if(node[v.first] != -2 && v.second < node[v.first]){
					Edge e = new Edge(nodeToEdge[v.first], u, v.first, v.second);
					queue.update(nodeToEdge[v.first], e);
					node[v.first] = v.second;
				}
			}
			
		}
		return MST;
		
	}
}
