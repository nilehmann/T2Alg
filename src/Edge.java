public class Edge implements Comparable<Edge> { 
  
    private int ID; 
    private int startNode; 
    private int endNode; 
    private double distance; 
      
    public Edge(int id, int sn, int en, double dist){ 
        ID=id; 
        startNode=sn; 
        endNode=en; 
        distance=dist;       
    } 
    
    public String toString(){
    	return ID+": ("+startNode+","+endNode+","+distance+")";
    }
    
    public double getDistance(){ 
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
		if(this.distance < o.distance)
			return -1;
		else if(this.distance > o.distance)
			return 1;
		else
			return 0;
	} 
} 