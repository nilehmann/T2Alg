import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Tarea2 {
	static int E = 179179;
	static int V = 175813;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("NA.cedge"));
		
		@SuppressWarnings("unchecked")
		List<Pair<Integer>> graph[] = new ArrayList[V];
		Edge edges[] = new Edge[E];
		for (int i = 0; i < V; i++) 
			graph[i] = new ArrayList<Pair<Integer>>();
		
		readGraph(graph, edges, V, E);
		
		QuickSort.sort(edges);
		
		for (int i = 1; i < edges.length; i++) {
			if (edges[i].compareTo(edges[i-1]) == 0) {
				System.out.println(edges[i]);
			}
		}
	
		
		Prim p = new Prim(graph, V);
		System.out.println(p.compute(175812).size());
		

		Kruskal k = new Kruskal(edges, V);
		System.out.println(k.compute().size());
		
		Dijkstra d = new Dijkstra(graph, V);
		
		System.out.println(d.compute(1, 175812));
	}
	
	static void readGraph(List<Pair<Integer>> graph[], Edge edges[], int V, int E) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int max = -1;
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int dist = (int) Math.round(Double.parseDouble(st.nextToken())*100000);
			
			max = Math.max(max,n1);
			max = Math.max(max,n2);
			
			edges[i] = new Edge(i, n1, n2, dist);	
			
			graph[n1].add(new Pair<Integer>(n2,dist));
			graph[n2].add(new Pair<Integer>(n1,dist));		
		}
			
	}
	
}
