
public class Hash {
	private Edge arr[];
	private int overload;
	
	public Hash(int N, int overload){
		arr = new Edge[N*overload];
		this.overload = overload;
	}
	
	public int add(int i, Edge a){
		i = overload*i;
		while(arr[i++] != null);
		arr[--i] = a;
		return i;
	}
	
	public Edge get(int i){
		return arr[i];
	}
}
