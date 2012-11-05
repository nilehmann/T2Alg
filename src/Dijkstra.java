import java.util.Arrays;
import java.util.List;


public class Dijkstra {
	static int HEAP = 1;
	static int TREAP = 2;
	static int ARRAY = 3;
	
	
	private List<Pair<Integer>> graph[];
	private PriorityQueue<Integer> queue;
	private int N;
	
	public Dijkstra(List<Pair<Integer>> graph[], int N, int minMethod){
		this.graph = graph;
		this.N = N;
		
		if(minMethod == HEAP)
			queue = new Heap<Integer>(N);
		else if(minMethod == TREAP)
			queue = new Treap<Integer>(N);
		else if(minMethod == ARRAY)
			queue = new PriorityArray<Integer>(N);
		else
			queue = new Heap<Integer>(N);
			
	}
	
	
	public int[] compute(int s){		
		int dist[] = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		queue.clear();
		queue.offer(s,0);
		
		while(queue.size()>0){
			Pair<Integer> nodo = queue.poll();
			dist[nodo.first] = nodo.second;
			
			for(Pair<Integer> vecino : graph[nodo.first]){
				int new_dist =  dist[nodo.first] + vecino.second;
				if(dist[vecino.first] == Integer.MAX_VALUE){
					queue.offer(vecino.first, new_dist);
					dist[vecino.first] = new_dist;
				}
				else if(new_dist < dist[vecino.first]){
					queue.update(vecino.first, new_dist);
					dist[vecino.first] = new_dist;
				}
			}
		}
		
		return dist;		
	}
}