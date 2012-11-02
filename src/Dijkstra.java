import java.util.List;



public class Dijkstra {
	private List<Pair<Double>> graph[];
	private PriorityQueue<Double> queue;
	private int N;
	
	public Dijkstra(List<Pair<Double>> graph[], int N){
		this.graph = graph;
		this.N = N;
		queue = new Heap<Double>(N);
	}
	
	
	public double compute(int s, int t){
		queue.clear();
		
		Pair<Double> arr[] = new Pair[N+1];
		Double dist[] = new Double[N+1];
		for (int i = 1; i <= N; i++){
			arr[i] = new Pair<Double>(i, Double.MAX_VALUE-5);
			dist[i] = Double.MAX_VALUE;
		}
		arr[s] = new Pair<Double>(s,0.0);
		queue.construct(arr);
		
		
		while(queue.size()>0){
			Pair<Double> nodo = queue.poll();
			dist[nodo.first] = nodo.second;
			
			for(Pair vecino : graph[nodo.first]){
				double new_dist =  dist[nodo.first] + (Double) vecino.second;
				if(new_dist < dist[vecino.first]){
					queue.update(vecino.first, new_dist);
					dist[vecino.first] = new_dist;
				}
			}
		}
		
		return dist[t];		
	}
}