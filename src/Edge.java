public class Edge implements Comparable<Edge> { 
  
    private int ID; 
    private int startNode; 
    private int endNode; 
    private int distance; 
      
    public Edge(int id, int sn, int en, int dist){ 
        ID=id; 
        startNode=sn; 
        endNode=en; 
        distance=dist;       
    } 
    
    public String toString(){
    	return ID+": ("+startNode+","+endNode+","+distance+")";
    }
    
    public int getDistance(){ 
        return distance; 
    } 
      
    public int getStartNode(){ 
        return startNode; 
    } 
      
    public int getEndNode(){ 
        return endNode; 
    } 
  
    public int getID(){ 
        return ID; 
    }

	@Override
	public int compareTo(Edge o) {
		if(this.distance == o.distance)
			return this.ID - o.ID;
		return this.distance - o.distance;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Edge ){
			Edge e = (Edge) o;
			return startNode == e.startNode && endNode == e.endNode && distance == e.distance;
		}
		return false;
	}
} 