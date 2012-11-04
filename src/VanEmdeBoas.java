import java.util.LinkedList;
import java.util.List;


public class VanEmdeBoas {
	private int M;
	private int size;
	private int min;
	private int max;
	
	private VanEmdeBoas top;
	private VanEmdeBoas trees[];
	private int sqrt;
	
	
	public VanEmdeBoas(int M) {
		this.M = M;
		sqrt = (int) Math.ceil((Math.sqrt(M)));
		max = -1;
		min = M;
		if(M>2){
			top = new VanEmdeBoas(sqrt);
			trees= new VanEmdeBoas[sqrt];
			for(int i=0; i<sqrt; i++)
				trees[i]=new VanEmdeBoas(sqrt);
		}
	}
	
	
	public int findNext(int x){
		if(x <= min){
			return min;
		}
		if(x > max){
			return M;
		}
		if(x==max)//agregado por tefa
			return max;
		
		if(top.min > top.max){
			if( x > min)
				return max;
			return M;
		}
		int i = x/sqrt;
		int lo = x%sqrt;
		int hi = x - lo;
		if(lo <= trees[i].max){//
			return hi + trees[i].findNext(lo);
		}
		int next = top.findNext(i+1);
		if(next == sqrt)
			return max; // return M?
		return next*sqrt + trees[next].min;
	}
	
	public void insert(int x){
		//System.out.println(x+" "+M);
		if(min > max){
			min = max = x;
			//System.out.println("1 min: "+min+" max: "+max);
			size++;
			return;
		}
		if(min == max){
			if(x  < min){
				min = x;
				size++;
			}
			if(x > max){
				max = x;
				size++;
			}
			//System.out.println("2 min: "+min+" max: "+max);
			return;
		}
		if(x < min){
			int temp = min;
			min = x;
			x = temp;
		}
		if(x > max){
			int temp = max;
			max = x;
			x = temp;
		}
		//System.out.println("3 min: "+min+" max: "+max);
		int i = x/sqrt;
		trees[i].insert(x % sqrt);
		if(trees[i].min == trees[i].max)
			top.insert(i);
		
	}
}