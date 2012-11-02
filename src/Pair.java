
class Pair<T extends Comparable <T>>{
	int first;
	T second;
	
	public Pair(int k, T v){
		first = k;
		second = v;
	}

	public String toString(){
		return "("+first+","+second+")";
	}
}