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
	
	
	public double compute(int s, int t){
		queue.clear();
		
		Integer dist[] = new Integer[N+1];
		for (int i = 0; i < N; i++){
			if(i!= s){
				queue.offer(i, Integer.MAX_VALUE);
				dist[i] = Integer.MAX_VALUE;
			}
		}
		queue.offer(s,0);
		
		while(queue.size()>0){
			Pair<Integer> nodo = queue.poll();
			dist[nodo.first] = nodo.second;
			
			for(Pair<Integer> vecino : graph[nodo.first]){
				int new_dist =  dist[nodo.first] + vecino.second;
				if(new_dist < dist[vecino.first]){
					queue.update(vecino.first, new_dist);
					dist[vecino.first] = new_dist;
				}
			}
		}
		
		return dist[t];		
	}
}