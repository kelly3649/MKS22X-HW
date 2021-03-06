import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean IsMax;

    public MyHeap(boolean isMax){
	IsMax = isMax;
	size = 0;
	data = (T[]) new Comparable[10];
    }
    public MyHeap(T[] array, boolean isMax){
	IsMax = isMax;
	size = 0;
	for(int i = 1;i<array.length-1;i++){
	    if(array[i+1] != null){
		size++;
	    }
	}
	size++;
	System.out.println("size is " + size);
	data = array;
    }
    public int compare(int ind1, int ind2){
	if(IsMax){
	    return data[ind1].compareTo(data[ind2]);
	}
	else{
	    return -1 * data[ind1].compareTo(data[ind2]);
	}
    }
	/**pushDown
	   precondition: datas[k]'s children are valid heaps
	   postconditions:-the element at index k has been 
	   shifted to the correct spot.
	   -data[k] and is a valid heap
	**/
    private void swap(int ind1, int ind2){
	T temp = data[ind1];
	data[ind1] = data[ind2];
	data[ind2] = temp;
    }
    private void pushDown(int k){
	while(k <= size/2){
	    // System.out.println("k = " + k);    
	    if(compare(k*2-1,k*2) > 0){
		if(compare(k*2-1,k) > 0){
		    swap(k*2-1,k);
		    k = k*2-1;
		}
		else{
		    return;
		}
	    }
      	 else if(compare(k*2,k) > 0){
		swap(k*2,k);
		k = k*2;
	    }
	    else{
		return;
	    }
	}
    }

	/**pushUp
	   precondition: data is a heap with at most one item
	   out of place (element at k)
	   postconditions:-the element at index k has been 
	   shifted to the correct spot.
	   -data is a valid heap
	**/
    private void pushUp(int k){
	while(k > 1){
	    if(compare(k/2,k)<0){
		    swap(k/2,k);
		    k = k/2;
	    }
	    else{
		return;
	    }
	}
    }
    public T delete(){  /**Throws a no such element exception if size==0 when called**/
	T temp;
	if(size == 0){
	    throw new NoSuchElementException();
	} 
	if(size == 1){
	    temp = data[1];
	    data[1] = null;
	    size--;	    
	}
	else{
	//always delete the root
	    temp = data[1];
	    swap(1,size);
	    data[size] = null;
	    size--;
	    System.out.println(toString()); // WORKS
	    System.out.println(size);
	    pushDown(1);
	}
	return temp;
    }

    public T peek(){    /**Throws a no such element exception if size==0 when called**/
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[1];
	}
}
    public void add(T x){
	if(size + 1 > data.length){
	    doubleSize();
	}
	data[size+1] = x;
	pushUp(size+1);
	size++;
    }
    private void heapify(){
	for(int i = size/2;i>0;i--){
	    pushDown(i);
	}
    }
    private void doubleSize(){
	T[] temp;
	temp = (T[]) new Comparable[data.length*2];
	for(int i = 0;i<data.length;i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
	/**toString returns an array style string, without any nulls   **/
    public String toString(){
	String retString = "[";
        for(int i = 1;i<size;i++){
	    retString += data[i] + ",";
	}
	retString += data[size] + "]";
	return retString;
    }
    public int getSize(){
	return size;
    }

	//do this last
   
    public static void main(String[]args){
	MyHeap<Integer> m1 = new MyHeap<Integer>(false);
	MyHeap<Integer> m2 = new MyHeap<Integer>(false);
	m1.add(5);
	System.out.println("ITS WORKING");
	m1.add(4);
	m1.add(3);
	m1.add(-1);
	m1.add(10);
	System.out.println("ITS WORKING");
	System.out.println(m1);
	m1.delete();
	System.out.println(m1);
	m1.delete();
        System.out.println(m1);
System.out.println("ITS WORKING");
    }
}

