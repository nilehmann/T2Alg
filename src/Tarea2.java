import java.util.ArrayList;
import java.util.List;



public class Tarea2 {
	public static void main(String[] args) {
		int n = 6;
		List<Pair> graph[] = new ArrayList[n+1];
		
		for (int i = 0; i <= n; i++) 
			graph[i] = new ArrayList<Pair>();
		
		graph[1].add(new Pair(6,14));
		graph[1].add(new Pair(3,9));
		graph[1].add(new Pair(2,7));
		
		graph[2].add(new Pair(1,7));
		graph[2].add(new Pair(3,10));
		graph[2].add(new Pair(4,15));
		
		graph[3].add(new Pair(1,9));
		graph[3].add(new Pair(2,10));
		graph[3].add(new Pair(6,2));
		graph[3].add(new Pair(4,11));

		graph[4].add(new Pair(3,11));
		graph[4].add(new Pair(2,15));
		graph[4].add(new Pair(5,6));
		
		graph[5].add(new Pair(4,6));
		graph[5].add(new Pair(6,9));

		graph[6].add(new Pair(5,9));
		graph[6].add(new Pair(1,14));
		graph[6].add(new Pair(3,2));
		
		Prim p = new Prim(graph, n);
		for(Edge e : p.compute(1)){
			System.out.println(e);
		}
	}
}
