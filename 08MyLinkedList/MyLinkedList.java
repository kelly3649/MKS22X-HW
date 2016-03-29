import java.util.*;

public class MyLinkedList<T>{// implements Iterabke<T>{
    
     public Iterator<T> iterator(){
	return new MyLinkedListIterator(); //only time you make this
	} 
     public class MyLinkedListIterator implements Iterator<T>{
	 private LNode next;
	 public MyLinkedListIterator(){
	     next = head;
	 }
	 public boolean hasNext(){
	     return next != null;
	 }
	 public T next(){
	     if(!hasNext()){
		 throw new NoSuchElementException();
	     }
	     T value = next.getValue();
	     next = next.getNext();
	     return value; //advance the pointer bfr returns!
	 } 
	 public void remove(){//optional, not wanted
	     throw new UnsupportedOperationException(); 
	 }   
     }
    private class LNode{
	T value;
	LNode next;
	public LNode(T val){
	    value = val;
	    next = null;
	}
	public String toString(){
	    return value.toString();
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(T val){
	    value = val;
	}
	public void setNext(LNode nxt){
	    next = nxt;
	}
    }
    LNode head, tail;
    int size;
    //dont need constructor, bc start and size are naturally null and 0
        
    public T get(int index){
	//throw exception
	if(index<0 || index>= size()){
	    System.out.println("INDEX OUT OF BOUNDS");
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	while(i<index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }
    public T set(int index, T newValue){
	//throw exception
	if(index<0 || index>= size()){
	    System.out.println("INDEX OUT OF BOUNDS");
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	while(i<index){
	    current=current.getNext();
	    i++;
	}
	T copy = current.getValue();
	current.setValue(newValue);
	return copy;
    }
    public int size(){
	return size;
    }
    public T remove(int index){
	//throw exception
	if(index<0 || index >= size()){
	    System.out.println("INDEX OUT OF BOUNDS");
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int i = 0;
	T copy;
	if(size == 1){
	    copy = head.getValue();
	    head = null;
	    tail = head;
	    size--;
	    return copy;
	}
	if(index == 0){
	    copy = current.getValue();
	    current.setValue(current.getNext().getValue());
	    current.setNext(current.getNext().getNext());
	}
	else{
	    while(i<index-1){
		current = current.getNext();
		i++;
	    }
	    if(index == size-1){ //removing the last element
		copy = current.getNext().getValue();
		current.setNext(null);
		tail = current;
	    }
	    else{
	    copy = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	    }
	}
	size--;
	return copy;
    }
    public boolean add(T val){
	System.out.println(head + " " + tail);
	if(head == null){
	    head = new LNode(val);
	    tail = head;
	}
	else if(size() == 1){
	    head.setNext(new LNode(val));
	    tail = head.getNext();
	}
	else{
	    //LNode current = tail;
	    tail.setNext(new LNode(val));
	    tail = tail.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int index, T value){
	//throw exception
	if(index < 0 || index > size){
	    System.out.println("INDEX OUT OF BOUNDS");
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	if(index == 0){
	    head = new LNode(value);
	    head.setNext(current);
	    size++;
	    return true;
	}
	else{
	    int i = 0;
	    while(i<index-1){
		current = current.getNext();
		i++;
	    }
	    if(index == size){
		current.setNext(new LNode(value));
		tail = current.getNext();
	    }
	    else{
		LNode newNode = new LNode(value);
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	    }
	    size++;
	    return true;
	}
    }
    public int indexOf(T value){
	LNode current = head;
	int i = 0;
	while(i<size()){
	    if(current.getValue().equals(value)){
		return i;
	    }
	    if(current.getNext() != null){
	    current = current.getNext();
	    }
	    i++;
	}
	return -1;
    }
    public String toString(){
	String retString = "[";
        LNode current = head;
	while(current != null){
	    retString += current.getValue();
	    if(current.getNext() != null){
	     retString += ", ";
	    }
	    current = current.getNext();
	}
	return retString + "]"; 
    }
   
    public String toString(boolean b){
	String retString = "size is " + size();
	if(b == true){
	    if(size() != 0){
	    retString += "[" + head.getValue() + ", ]...[" + tail.getValue() + ", ]" + "\n [";       
	    LNode current = head;
	    while(current != null){
		retString += current.getValue();
		if(current.getNext() != null){
		    retString += ", ";
		}
		current = current.getNext();
	    }
	    return retString + "]"; 
	    }
	}
	return retString;
    }
    public static void main(String[] args){
	
	MyLinkedList<Integer> l1 = new MyLinkedList<Integer>();
	l1.add(3);
	System.out.println(l1);
       	l1.add(4);
	System.out.println(l1);
	l1.add(5);
	System.out.println(l1);
     	System.out.println("size is " + l1.size());
	try{
	l1.remove(1);
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Index out of bounds");
	}
	System.out.println(l1);
	System.out.println("size is " + l1.size());
	System.out.println("element/index " + l1.get(1) + "/1");
	l1.set(1,13);
	System.out.println("element/index " + l1.get(1) + "/1");
	System.out.println(l1);
	l1.add(1,4);//is add(index,val) NOT the usual way around
	System.out.println(l1);
	l1.add(3,-5);
	System.out.println(l1);
 	l1.add(0,6);
	System.out.println(l1);

	System.out.println("element -5 can be found at index: " + l1.indexOf(-5));
	System.out.println("element 4 can be found at index: " + l1.indexOf(4));
	
	MyLinkedList<Integer> n = new MyLinkedList<Integer>();
	for(int i=0;i<10;i++){
	    n.add(i);
	}
	System.out.println(n);
	Iterator<Integer> it = n.iterator();
	Iterator<Integer> it2 = n.iterator();

	System.out.println(it.next());
	System.out.println(it.next());
	
	    }
}
