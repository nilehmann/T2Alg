
public interface PriorityQueue<T extends Comparable<T>> {
	int size();
	Pair<T> poll();
	void offer(int key, T val);
	void update(int key, T val);
	void construct(Pair<T> arr[]);
	void clear();
}
