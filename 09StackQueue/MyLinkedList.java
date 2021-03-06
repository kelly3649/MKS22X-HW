import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private class LNode{
	private T value;
	private LNode next;
	private LNode prev;
	public LNode(T v){
	    value = v;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public LNode getPrev(){
	    return prev;
	}
	public T setValue(T v){
	    T old = value;
	    value = v;
	    return old;
	}
	public void setNext(LNode n){
	    next = n;
	}
	public void setPrev(LNode p){
	    prev = p;
	}
	public String toString(){
	    return value.toString();
	}
    }

    LNode head;
    LNode tail;
    int size;
    
    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	{
	    private LNode current = head;

	    public boolean hasNext(){
		return current != null;
	    }
	    public T next(){
		if(!hasNext()){
		    throw new NoSuchElementException();
		}
		T value = current.getValue();
		current = current.getNext();
		return value;
	    }
	    public void remove(){
		throw new UnsupportedOperationException();
	    }
	};
    } 
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans += p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public String toString(boolean b){
	return toString()+" head: "+head +", tail: "+tail;
    }
    private LNode getNth(int index){
	//check bounds before calling this method!
	LNode temp = head;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    public boolean add(T value){
	if(head == null){
	    head = new LNode(value); //next and prev will aut be null
	    tail = head;
	}else{
	    LNode p = new LNode(value);
	    p.setPrev(tail);
	    tail.setNext(p);
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = head;
	    head.getNext().setPrev(null);
	    head = head.getNext();	    
	    if(head == null){ //if there was only one element
		tail = null;
	    }
	}else if(index == size-1){
	    temp = tail;
	    tail.getPrev().setNext(null);
	    tail = tail.getPrev();
	}
	else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    p.setNext(p.getNext().getNext());
	    p.getNext().setPrev(p);
	}
	size--;
	return temp.getValue();
    }
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(head);
	    temp.setPrev(null);
	    head.setPrev(temp);
	    head = head.getPrev();
	    if(size>0){
		head.getNext().setPrev(head);
	    }
	    else{
		tail = head;
	    }
	}
	else if(index == size){
	    temp.setPrev(tail);
	    temp.setNext(null);
	    tail.setNext(temp);
	    tail = tail.getNext();
	}
	else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    temp.setPrev(p);
	    p.getNext().setPrev(temp);
	    p.setNext(temp);
	}
	size++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).getValue();
    }

    public T set(int index, T newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	return getNth(index).setValue(newValue);
    }

    public int indexOf(T target){
	LNode temp = head;
	int index = 0;
	while(temp != null){
	    if(temp.getValue().equals(target)){
		return index;
	    }
	    index++;
	    temp = temp.getNext();
	}
	return -1;
    }

    public static void main(String[]args){
	
	MyLinkedList<Integer> m1 = new MyLinkedList<Integer>();
	for(int i = 0;i<10 ;i++){
	    m1.add(i);
	}
	System.out.println(m1);
	m1.remove(0);
	System.out.println(m1);
	m1.remove(1);
	System.out.println(m1);
	m1.remove(7);
	System.out.println(m1);
	m1.add(0,0);
	System.out.println(m1);
	m1.add(8,9);
	System.out.println(m1);
	m1.add(8,-20);
	System.out.println(m1);
    }
	
}
