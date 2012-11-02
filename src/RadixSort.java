public class RadixSort {

    static void radixSort(int[] input, int u) {
    	CountingValue arr[] = new CountingValue[input.length]; 
    	for (int i = 0; i < arr.length; i++) 
			arr[i] = new CountingValue(-1, input[i]);
    	
    	for (int dig = 1, div = 1; dig <= u; dig++, div *=10) {
    		for (int i = 0; i < arr.length; i++){
    			arr[i].key = getDigit(arr[i].val, div);
    		}
			countingSort(arr,10);
			
		}
    	
    	for (int i = 0; i < arr.length; i++) {
			input[i] = arr[i].val;
		}
    	
    }
    
    static void countingSort(CountingValue arr[], int N){
    	int count[] = new int[N];
    	
    	for(CountingValue i : arr)
    		count[i.key]++;
    	
    	int prev = count[0];
    	count[0] = 0;
    	for (int i = 1; i < N; i++){
    		int temp = count[i];
			count[i] = count[i-1] + prev; 
			prev = temp;
    	}

    	
    	CountingValue sorted[] = new CountingValue[arr.length];
    	for(CountingValue i : arr){
    		sorted[count[i.key]++] = i;
    	}
    	for (int i = 0; i < arr.length; i++) 
			arr[i] = sorted[i];
		
		
    }
   
    static int getDigit(int integer, int divisor) {
        return (integer / divisor) % 10;
    }
    
}

class CountingValue{
	int key;
	int val;
	
	public CountingValue(int k, int v){
		key = k;
		val = v;
	}
}

