
public class Treap implements PriorityQueue{
	private TreapNode root;
	private int size;
	
	
	public Treap(int n){
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Pair poll() {
		Pair p = root.p;
		delete(root.key());
		return p;
	}


	@Override
	public void offer(int key, double val) {
		insert(key,val);
	}
	
	@Override
	public void construct(Pair arr[]){
		for (int i = 0; i < arr.length; i++) 
			insert(arr[i].first, arr[i].second);
		
	}
	
	@Override 
	public void clear(){
		root = null;
	}
	
	
	
	@Override
	public void update(int key, double val){
		root = update(root,key,val);
	}
	
	private TreapNode update(TreapNode n, int key, double val){
		if(n == null)
			return null;
		
		if(key == n.key()){
			n.update(val);
			if(n.right == null && n.left == null)
				return n;
			
			double val_right = (n.right == null) ? Double.MAX_VALUE: n.right.val();
			double val_left = (n.left == null) ? Double.MAX_VALUE: n.left.val();
			
			if(val_right < val_left && n.val() > val_right){
				n = rotateLeft(n);
				n.left = update(n.left,key, val);
			}
			else if(val_left < val_right && n.val() > val_left){
				n = rotateRight(n);
				n.right = update(n.right, key, val); 
			}		
		}
		else if(key < n.key()){
			n.left = update(n.left, key, val);
			if( n.left != null && n.val() > n.left.val())
				n = rotateRight(n);
		}
		else{
			n.right = update(n.right, key, val);
			if(n.right != null && n.val() > n.right.val())
				n = rotateLeft(n);
		}
		return n;
	}
	

	
	public Pair search(int key){
		TreapNode n = search(root, key);
		if(n == null)
			return null;
		return n.p;
	}
	
	
	private TreapNode search(TreapNode n, int k){
		if(n == null)
			return null;
		
		if(n.key()== k)
			return n;
		
		if(k < n.key())
			return search(n.left, k);
		else
			return search(n.right, k);
	}
	
	public void insert(int key, double val){
		root = insert(root, new TreapNode(key, val));
	}
	

	private TreapNode insert(TreapNode n, TreapNode ins){
		if(n == null){
			++size;
			return ins;
		}
		
		if(ins.key() < n.key()){
			n.left = insert(n.left, ins);
			
			if(n.val() > n.left.val())
				n = rotateRight(n);
		}
		else if(ins.key() > n.key()){
				n.right = insert(n.right, ins);
			
			if(n.val() > n.right.val())
				n = rotateLeft(n);
		}
		
		return n;
	}
	
	public void delete(int key){
		root = delete(root, key);
	}
	
	private TreapNode delete(TreapNode n, int key){
		if(n == null)
			return null;
		if(n.key() == key){
			size--;
			if(n.left == null)
				return n.right;
			if(n.right == null)
				return n.left;
			
			if(n.right.val() < n.left.val()){
				n = rotateLeft(n);
				n.left = delete(n.left,key);
			}
			else{
				n = rotateRight(n);
				n.right = delete(n.right, key); 
			}			
		}
		else{
			if(key < n.key())
				n.left = delete(n.left, key);
			else if(key > n.key())
				n.right = delete(n.right, key);
		}
		return n;			
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(TreapNode n){
		if(n== null)
			return 0;
		
		return Math.max(height(n.left)+1, height(n.right)+1);
	}

	
	
	private TreapNode rotateRight(TreapNode root){
		TreapNode pivot = root.left;
		root.left = pivot.right;
		pivot.right = root;
		
		return pivot;
	}
	
	
	private TreapNode rotateLeft(TreapNode root){
		TreapNode pivot = root.right;
		root.right = pivot.left;
		pivot.left = root;
		
		return pivot;
	}
	
}

class TreapNode{	
	TreapNode right;
	TreapNode left;
	
	Pair p;

	public TreapNode(int k, double v){
		p = new Pair(k,v);
	}
	
	public void update(double v){
		p.second = v;
	}
	
	public int key(){
		return p.first;
	}
	public double val(){
		return p.second;
	}
	
	public String toString(){
		return "("+p.first+", "+p.second+")";
	}
}