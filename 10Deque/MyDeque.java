import java.util.*;

public class MyDeque<T>{
    private T[] ary;
    private int size;
    private int start;
    private int end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (T[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }

    public String toString(){
	String retString = "[";
	int i = 0;
	while(i<ary.length - 1){
	    retString += ary[i] + ", ";
	    i++;
	}
        retString += ary[ary.length-1] + "] ";// + ary.length + start + end;
	return retString;
    }
    @SuppressWarnings("unchecked")
    private void copyOver(){
	T[] temp = (T[]) new Object[size*2];
	if(end < start){// then you know that start != 0   
	    for(int i = start;i<ary.length;i++){
		temp[i-start] = ary[i];
	    }
	    for(int i = 0;i<end+1;i++){
		temp[ary.length-start+i] = ary[i];
	    }
	}
	ary = (T[]) new Object[temp.length];
	for(int i = 0;i<temp.length;i++){
	    ary[i] = temp[i];
	}
	//once you copy over,change start and end to normal
	start = 0;
	end = size-1;
	//System.out.println(toString());
    }
	
@SuppressWarnings("unchecked")	
    void addFirst(T value){
	if(size == ary.length){
	    copyOver();
	}
	if(size != 0){
	    if(start == 0){
		start = ary.length-1;
	    }
	    else{
		start--;
	    }
	}
        ary[start] = value;
	size++;
    }
    @SuppressWarnings("unchecked")
    void addLast(T value){
	if(size == ary.length){
	    copyOver();
	}
	if(size != 0){
	    if(end == ary.length-1){ 
		end = 0;
	    }
	    else{
		end++;
	    }
	}
	ary[end] = value;
	size++;
    }
    T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T first = ary[start];
	ary[start] = null;
	if(start == ary.length-1){
	    start = 0;
	}
	else{
	    start++;
	}
	size--;
	return first;
    }
    
    T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T last = ary[end];
	ary[end] = null; //counts as rmving
	if(end == 0){
	    end = ary.length-1;
	}
	else{
	    end--;
	}
	size--;
	return last;
    }
    T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[start];
    }
    T getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[end];
    }

    public static void main(String[]args){
	MyDeque m1 = new MyDeque();
	m1.addFirst(10);
	m1.addLast(-10);
	System.out.println(m1.removeFirst());
	int i = 0;
	while(i<10){
	 m1.addLast(i);
	 System.out.println(m1);
	 i++;
	}
    }
}
	
