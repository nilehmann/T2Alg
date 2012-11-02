import java.util.ArrayList;
import java.util.List;



public class Tarea2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		int n = 10000000;
//		PriorityQueue<Double> q = new Treap<Double>(n);
//		
//		for (int i = 0; i < n; i++) {
//			q.offer(i, Math.random());
//		}
//		
//		for (int i = 0; i < n; i++) {
//			q.update(i, Math.random());
//		}
//		
//		Pair<Double><Double> ant = q.poll();
//		while(q.size() > 0){
//			Pair<Double><Double> p = q.poll();
//			if(ant.second.compareTo(p.second) > 0)
//				System.out.println("problemas");
//			ant = p;
//		}
		
		int n = 6;
		List<Pair<Double>> graph[] = new ArrayList[n+1];
		
		for (int i = 0; i <= n; i++) 
			graph[i] = new ArrayList<Pair<Double>>();
		
		graph[1].add(new Pair<Double>(6,14.0));
		graph[1].add(new Pair<Double>(3,9.0));
		graph[1].add(new Pair<Double>(2,7.0));
		
		graph[2].add(new Pair<Double>(1,7.0));
		graph[2].add(new Pair<Double>(3,10.0));
		graph[2].add(new Pair<Double>(4,15.0));
		
		graph[3].add(new Pair<Double>(1,9.0));
		graph[3].add(new Pair<Double>(2,10.0));
		graph[3].add(new Pair<Double>(6,2.0));
		graph[3].add(new Pair<Double>(4,11.0));

		graph[4].add(new Pair<Double>(3,11.0));
		graph[4].add(new Pair<Double>(2,15.0));
		graph[4].add(new Pair<Double>(5,6.0));
		
		graph[5].add(new Pair<Double>(4,6.0));
		graph[5].add(new Pair<Double>(6,9.0));

		graph[6].add(new Pair<Double>(5,9.0));
		graph[6].add(new Pair<Double>(1,14.0));
		graph[6].add(new Pair<Double>(3,2.0));
		
		Prim p = new Prim(graph, n);
		for(Edge e : p.compute(1)){
			System.out.println(e);
		}
		
		Dijkstra d = new Dijkstra(graph, n);
		
		System.out.println(d.compute(1, 5));
	}
}
