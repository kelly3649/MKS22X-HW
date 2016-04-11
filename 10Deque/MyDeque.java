import java.util.*;

public class MyDeque<T>{
    private T[] ary;
    private int size;
    private int start;
    private int end;

    public MyDeque(){
	ary = new T[10];
	size = 10;
	start = 0;
	end = 9;
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
	
    void addFirst(T Value){
    }
    void addLast(T value){
	if(size == ary.length){
	    copyOver();
	}
	
    }
    T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
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

    public static void main(String[]args){
	MyDeque m1 = new MyDeque();
	
