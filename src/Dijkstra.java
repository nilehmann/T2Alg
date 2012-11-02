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
		
		Double dist[] = new Double[N+1];
		for (int i = 0; i < N; i++){
			if(i!= s){
				queue.offer(i, Double.MAX_VALUE);
				dist[i] = Double.MAX_VALUE;
			}
		}
		queue.offer(s,0.0);
		
		while(queue.size()>0){
			Pair<Double> nodo = queue.poll();
			dist[nodo.first] = nodo.second;
			
			for(Pair<Double> vecino : graph[nodo.first]){
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