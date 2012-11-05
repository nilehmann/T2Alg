import java.util.Arrays;


public class PriorityArray<T extends Comparable<T>> implements PriorityQueue<T>{
	private Pair<T> arr[];
	private int size;
	
	@SuppressWarnings("unchecked")
	public PriorityArray(int N){
		arr = new Pair[N+1];
		size = 0;
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Pair<T> poll() {
		size--;
		int i;
		for(i = 0; arr[i] == null; ++i);
		
		Pair<T> min = arr[i];
		int imin = i;
		for (i = i+1;i < arr.length; ++i) {
			if(arr[i] != null && arr[i].second.compareTo(min.second) < 0){
				min =  arr[i];
				imin = i;
			}
		}
		
		arr[imin] = null;
		return min;		
	}

	@Override
	public void offer(int key, T val) {
		size++;
		arr[key] = new Pair<T>(key, val);
	}

	@Override
	public void update(int key, T val) {
		arr[key].second = val;		
	}

	@Override
	public void clear() {
		Arrays.fill(arr, null);
		size = 0;
	}
	
}
