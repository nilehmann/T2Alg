
public class Treap<T extends Comparable<T>> implements PriorityQueue<T>{
	private TreapNode<T> root;
	private int size;
	
	
	public Treap(int n){
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Pair<T> poll() {
		Pair<T> p = root.p;
		delete(root.key());
		return p;
	}


	@Override
	public void offer(int key, T val) {
		insert(key,val);
	}

	
	@Override 
	public void clear(){
		root = null;
	}
	
	

	@Override
	public void update(int key, T val){
		root = update(root,key,val);
	}

	private TreapNode<T> update(TreapNode<T> n, int key, T val){
		if(n == null)
			return null;
		
		if(key == n.key()){
			n.update(val);
			if(n.right == null && n.left == null)
				return n;
			
			if(n.left == null || (n.right != null && n.right.val().compareTo(n.left.val())<0 )){
				if( n.val().compareTo(n.right.val()) > 0){
					n = rotateLeft(n);
					n.left = update(n.left,key, val);
				}
				
			}
			else if(n.right == null || (n.left != null && n.left.val().compareTo(n.right.val())<0) ){
				if(n.val().compareTo(n.left.val())>0){
					n = rotateRight(n);
					n.right = update(n.right, key, val); 
				}
			}	
		}
		else if(key < n.key()){
			n.left = update(n.left, key, val);
			if( n.left != null && n.val().compareTo(n.left.val())>0)
				n = rotateRight(n);
		}
		else{
			n.right = update(n.right, key, val);
			if(n.right != null && n.val().compareTo(n.right.val())>0)
				n = rotateLeft(n);
		}
		return n;
	}
	

	
	public Pair<T> search(int key){
		TreapNode<T> n = search(root, key);
		if(n == null)
			return null;
		return n.p;
	}
	
	
	private TreapNode<T> search(TreapNode<T> n, int k){
		if(n == null)
			return null;
		
		if(n.key()== k)
			return n;
		
		if(k < n.key())
			return search(n.left, k);
		else
			return search(n.right, k);
	}

	public void insert(int key, T val){
		root = insert(root, new TreapNode<T>(key, val));
	}
	

	private TreapNode<T> insert(TreapNode<T> n, TreapNode<T> ins){
		if(n == null){
			++size;
			return ins;
		}
		
		if(ins.key() < n.key()){
			n.left = insert(n.left, ins);
			
			if(n.val().compareTo(n.left.val())>0)
				n = rotateRight(n);
		}
		else if(ins.key() > n.key()){
				n.right = insert(n.right, ins);
			
			if(n.val().compareTo(n.right.val())>0)
				n = rotateLeft(n);
		}
		
		return n;
	}
	
	public void delete(int key){
		root = delete(root, key);
	}

	private TreapNode<T> delete(TreapNode<T> n, int key){
		if(n == null)
			return null;
		if(n.key() == key){
			size--;
			if(n.left == null)
				return n.right;
			if(n.right == null)
				return n.left;
			
			if(n.right.val().compareTo(n.left.val())<0){
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
	
	private int height(TreapNode<T> n){
		if(n== null)
			return 0;
		
		return Math.max(height(n.left)+1, height(n.right)+1);
	}

	
	
	private TreapNode<T> rotateRight(TreapNode<T> root){
		TreapNode<T> pivot = root.left;
		root.left = pivot.right;
		pivot.right = root;
		
		return pivot;
	}
	
	
	private TreapNode<T> rotateLeft(TreapNode<T> root){
		TreapNode<T> pivot = root.right;
		root.right = pivot.left;
		pivot.left = root;
		
		return pivot;
	}
	
}

class TreapNode<T extends Comparable<T>>{	
	TreapNode<T> right;
	TreapNode<T> left;
	
	Pair<T> p;

	public TreapNode(int k, T v){
		p = new Pair<T>(k,v);
	}

	public void update(T v){
		p.second = v;
	}
	
	public int key(){
		return p.first;
	}
	
	public T val(){
		return p.second;
	}
	
	public String toString(){
		return "("+p.first+", "+p.second+")";
	}
}