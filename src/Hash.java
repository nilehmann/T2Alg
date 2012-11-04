
public class Hash {
	private Edge arr[];
	
	public Hash(int N, int overload){
		arr = new Edge[N*overload];
	}
	
	public int add(int i, Edge a){
		while(arr[i++] != null);
		arr[--i] = a;
		return i;
	}
	
	public Edge get(int i){
		return arr[i];
	}
}
