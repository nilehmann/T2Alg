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
		int i = 0;
		while(arr[i++] == null);
		
		Pair<T> min = arr[i-1];
		int imin = i-1;
		for (;i < arr.length; ++i) {
			if(arr[i] != null && arr[i].second.compareTo(min.second) < 0){
				min =  arr[i];
				imin = i;
			}
		}
		arr[imin] = null;
		size--;
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
		for (int i = 0; i < arr.length; i++)
			arr[i] = null;
		size = 0;
	}
	
}
