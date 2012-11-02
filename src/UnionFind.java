public class UnionFind { 
	private int parent[];
    private int rank[];
	
	public UnionFind(int n){
		parent = new int[n+1];
		rank = new int[n+1];
		
		for (int i = 0; i <= n; i++){ 
			parent[i] = i;
			rank[i] = 0;
		}
		
		
	}

    //find con compresion de camino 
    public int find(int x){ 
         if (x != parent[x]) 
            parent[x] = find(parent[x]); 
         return parent[x];
    } 
    //find sin compresion de camino 
    public int findWO(int x){ 
         if (x == parent[x]) 
            return x; 
         else
            return findWO(parent[x]); 
          
    } 
    //union por rank 
    public void union(int x, int y){ 
        int xRoot=find(x); 
        int yRoot=find(y); 
        if(xRoot == yRoot) 
            return; 
        
         if (rank[xRoot] <= rank[yRoot]){
             parent[xRoot] = yRoot; 
             rank[yRoot] += rank[xRoot] + 1;
         }
         else{
             parent[yRoot] = xRoot; 
             rank[xRoot] += rank[yRoot] + 1;
         }
    } 
} 