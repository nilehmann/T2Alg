
public class FixedHeap implements Iterable{
	private Edge heap[];
	private int size;

	public FixedHeap(Edge arr[]){
		int N = arr.length;
		heap = new Edge[N+1];
		for (int i = 0; i < arr.length; i++) 
			heap[i+1] = arr[i];
		size = 0;
		int start = (N+1)/2;
		while(start >= 1){
			bubbleDown(start);
			start--;
		}		
	}
		
	
	@Override
	public Edge getNext() {
		if(size == 0)
			return null;
		return poll();
	}
	

	public Edge poll() {
		Edge p = heap[1];
		heap[1] = heap[size--];
		bubbleDown(1);
		return p;
	}
	
	
	public int size() {
		return size;
	}	
	
	public void clear(){
		for (int i = 0; i < size; i++) 
			heap = null;
		size = 0;
	}
	

	private void bubbleDown(int i){
		int k;
		while( 2*i <= size){
			k = 2*i;
			if(k+1 <= size && heap[k+1].compareTo(heap[k]) < 0)
				k = k+1;
			if(heap[i].compareTo(heap[k]) < 0)
				break;
			swap(i,k);
			i = k;
		}
	}

	private void bubbleUp(int i){
		while(i>1 && heap[i/2].compareTo(heap[i]) > 0){
			swap(i, i/2);
			i = i/2;
		}
	}
	
	
	private void swap(int i, int j){
		Edge temp = heap[i];
		
		heap[i] = heap[j];
		heap[j] = temp;
	}






	
	
}
