import java.util.List;



public class Dijkstra {
	private List<Pair> graph[];
	private PriorityQueue queue;
	private int N;
	
	public Dijkstra(List<Pair> graph[], int N){
		this.graph = graph;
		this.N = N;
		queue = new Heap(N);
	}
	
	
	public double compute(int s, int t){
		queue.clear();
		
		Pair arr[] = new Pair[N+1];
		double dist[] = new double[N+1];
		for (int i = 1; i <= N; i++){
			arr[i] = new Pair(i, Double.MAX_VALUE-5);
			dist[i] = Double.MAX_VALUE;
		}
		arr[s] = new Pair(s,0);
		queue.construct(arr);
		
		
		while(queue.size()>0){
			Pair nodo = queue.poll();
			dist[nodo.first] = nodo.second;
			
			for(Pair vecino : graph[nodo.first]){
				double new_dist =  dist[nodo.first] + vecino.second;
				if(new_dist < dist[vecino.first]){
					queue.update(vecino.first, new_dist);
					dist[vecino.first] = new_dist;
				}
			}
		}
		
		return dist[t];		
	}
}