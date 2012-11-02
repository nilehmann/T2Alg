
public class Heap<T extends Comparable<T>> implements PriorityQueue<T>{
	private Pair<T> heap[];
	private int position[];
	private int size;

	@SuppressWarnings("unchecked")
	public Heap(int n){
		heap = new Pair[n+1];
		position = new int[n+1];
		size = 0;
	}
	
	@Override
	public void offer(int key, T value) {
		heap[++size] = new Pair<T>(key,value);
		position[key] = size;
		
		bubbleUp(size);
	}


	@Override
	public Pair<T> poll() {
		Pair<T> p = heap[1];
		heap[1] = heap[size--];
		bubbleDown(1);
		return p;
	}
	
	@Override
	public void update(int key, T value){
		int i = position[key];
		heap[i].second = value;
		
		bubbleUp(i);
		bubbleDown(i);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void construct(Pair<T> arr[]){
		for (int i = 0; i < arr.length; i++) 
			offer(arr[i].first, arr[i].second);
		
	}
	
	@Override
	public void clear(){
		for (int i = 0; i < size; i++) 
			heap = null;
		size = 0;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 1; i <= size-1; i++) {
			sb.append(heap[i]+",");
		}
		sb.append(heap[size]+"]");
		
		return sb.toString();
		
	}	

	private void bubbleDown(int i){
		int k;
		while( 2*i <= size){
			k = 2*i;
			if(k+1 <= size && heap[k+1].second.compareTo(heap[k].second) < 0)
				k = k+1;
			if(heap[i].second.compareTo(heap[k].second) < 0)
				break;
			swap(i,k);
			i = k;
		}
	}

	private void bubbleUp(int i){
		while(i>1 && heap[i/2].second.compareTo(heap[i].second) > 0){
			swap(i, i/2);
			i = i/2;
		}
	}
	
	
	private void swap(int i, int j){
		Pair<T> temp = heap[i];

		position[heap[i].first] = j;
		position[heap[j].first] = i;
		
		heap[i] = heap[j];
		heap[j] = temp;
	}



	
	
}
