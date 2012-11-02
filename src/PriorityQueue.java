
public interface PriorityQueue {
	int size();
	Pair poll();
	void offer(int key, double val);
	void update(int key, double val);
	void construct(Pair arr[]);
	void clear();
}
