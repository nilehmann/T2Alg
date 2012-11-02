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
		
		List<Pair<Double>> graph[] = new ArrayList[V];
		Edge edges[] = new Edge[E];
		for (int i = 0; i < V; i++) 
			graph[i] = new ArrayList<Pair<Double>>();
		
		readGraph(graph, edges, V, E);
		
		Prim p = new Prim(graph, V);
		System.out.println(p.compute(175812).size());
		
		Dijkstra d = new Dijkstra(graph, V);
		
		System.out.println(d.compute(1, 175812));
	}
	
	static void readGraph(List<Pair<Double>> graph[], Edge edges[], int V, int E) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int max = -1;
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			double dist = Double.parseDouble(st.nextToken());
			
			max = Math.max(max,n1);
			max = Math.max(max,n2);
			
			edges[i] = new Edge(i, n1, n2, dist);	
			
			graph[n1].add(new Pair<Double>(n2,dist));
			graph[n2].add(new Pair<Double>(n1,dist));		
		}
			
	}
	
}
