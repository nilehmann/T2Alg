public class QuickSort implements Iterable { 
  private Edge[] numbers; 
  private int number; 
  private int current;
  
  
  public QuickSort(Edge[] values) { 
    // Check for empty or null array 
    if (values ==null || values.length==0){ 
      return; 
    }
    
    number = values.length; 
    numbers=new Edge[number];
    for(int i=0; i<number; i++)
    	numbers[i]=values[i];
    current=0;
    quicksort(numbers, 0, number - 1); 
  } 
  
  
  @Override
  public Edge getNext(){
	  return numbers[current++];
  }
  
  static public void quicksort(Edge[] numbers, int low, int high) { 
    int i = low, j = high; 
    // Get the pivot element from the middle of the list 
    Edge pivot = numbers[low + (high-low)/2]; 
  
    // Divide into two lists 
    while (i <= j) { 
      // If the current value from the left list is smaller then the pivot 
      // element then get the next element from the left list 
      while (numbers[i].getDistance() < pivot.getDistance()) { 
        i++; 
      } 
      // If the current value from the right list is larger then the pivot 
      // element then get the next element from the right list 
      while (numbers[j].getDistance() > pivot.getDistance()) { 
        j--; 
      } 
  
      // If we have found a values in the left list which is larger then 
      // the pivot element and if we have found a value in the right list 
      // which is smaller then the pivot element then we exchange the 
      // values. 
      // As we are done we can increase i and j 
      if (i <= j) { 
        exchange(numbers, i, j); 
        i++; 
        j--; 
      } 
    } 
    // Recursion 
    if (low < j) 
      quicksort(numbers,low, j); 
    if (i < high) 
      quicksort(numbers,i, high); 
  } 
  
  static private void exchange(Edge numbers[],int i, int j) { 
    Edge temp = numbers[i]; 
    numbers[i] = numbers[j]; 
    numbers[j] = temp; 
  }
  

}