
public class PriorityArray {

	private Pair array[];
	private int size;
	public PriorityArray(Pair arr[], int N){
		array = arr;
		size = N;
	}
	
	public void offer(int key, double val){
		array[key] = new Pair(key,val);
		size++;
	}

	
	public Pair poll(){
		double min_value = Double.MAX_VALUE;
		int imin = -1;
		for (int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].second <= min_value){
				min_value = array[i].second;
				imin = i;
			}
		}
		Pair p = array[imin];
		array[imin] = null;
		size--;
		return p;
	}
	
	public void update(int key, double val){
		if(array[key] != null)
			array[key].second = val;
	}
	
	public int size(){
		return size;
	}
}