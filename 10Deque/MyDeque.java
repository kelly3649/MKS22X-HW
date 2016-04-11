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
        retString += ary[ary.length-1] + "]";
	return retString;
    }
    @SuppressWarnings("unchecked")
    private T[] copyOver(){
	T[] temp = new T[size*2];
	if(end < start){// then you know that start != 0   
	    for(int i = start;i<ary.length;i++){
		temp[i-start] = ary[i];
	    }
	    for(int i = 0;i<end+1;i++){
		temp[ary.length-start+i] = ary[i];
	    }
	}
	ary = new T[temp.length];
	for(int i = 0;i<temp.length;i++){
	    ary[i] = temp[i];
	}
	System.out.println(toString());
    }
	/*else{//works
	    for(int i = start;i<end+1;i++){
		temp[i-start] = ary[i];
	    }
	    }*/
	
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
	
	return first;
    }
    
    T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
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

    
}
	
