import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;

    public MyHeap(){
	size = 0;
	data = new (T[])
    }
    public MyHeap(T[] array){
	size = 0;
	data = array;
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
	while(k <= size){
	    if(data[k*2].compareTo(data[k*2+1]) > 0){
		if(data[k*2].compareTo(data[k]) > 0){
		    swap(k*2,k);
		    k = k*2;
		}
	    }
	    else{
		if(data[k*2+1].compareTo(data[k]) > 0){
		    swap(k*2+1,k);
		    k= k*2+1;
		}
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
    }
    public T delete(){  /**Throws a no such element exception if size==0 when called**/}
    public T peek(){    /**Throws a no such element exception if size==0 when called**/}
    public void add(T x){
	for(int i = 0; i < size; i++){
	    if(data[i] == null){
		data[i] = x;
	    }
	}
    }
    private void heapify(){
	for(int i = size/2;i>0;i--){
	    pushDown(i);
    }
    private void doubleSize(){}
	/**toString returns an array style string, without any nulls   **/
    public String toString(){}


	//do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

	
}

