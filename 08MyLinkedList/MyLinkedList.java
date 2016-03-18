public class MyLinkedList{
    private class LNode{
	int value;
	LNode next;
	public LNode(int val){
	    value = val;
	    next = null;
	}
	public int getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(int val){
	    value = val;
	}
	public void setNext(LNode nxt){
	    next = nxt;
	}
    }
    LNode head;
    int size;
    //dont need constructor, bc start and size are naturally null and 0
        
    public int get(int index){
	LNode current = head;
	int i = 0;
	while(i<index){
	    current = current.getNext();
	    i++;
	}
	return current.getValue();
    }
    public int set(int index, int newValue){
	LNode current = head;
	int i = 0;
	while(i<index){
	    current=current.getNext();
	    i++;
	}
	int copy = current.getValue();
	current.setValue(newValue);
	return copy;
    }
    public int size(){
	return size;
    }
    public int remove(int index){
	LNode current = head;
	int i = 0;
	int copy;
	if(index == 0){
	    copy = current.getValue();
	    current.setValue(current.getNext().getValue());
	    current.setNext(current.getNext().getNext());
	}
	else{
	    while(i<index-1){
		current = current.getNext();
		i++;
	    }copy = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	}
	size--;
	return copy;
    }
    public boolean add(int val){
	if(head == null){
	    head = new LNode(val);
	}
	else{
	    LNode current = head;
	    while(current.getNext() != null){
		current = current.getNext();
	    }
	    current.setNext(new LNode(val));
	}
	size++;
	return true;
    }

    public boolean add(int index, int value){
	LNode current = head;
	if(index == 0){
	    head = new LNode(value);
	    head.setNext(current);
	    size++;
	    return true;
	}
	if(index == size()){
	    add(value);
	    size++;
	    return true;
	}
	else{
	    int i = 0;
	    while(i<index-1){
		current = current.getNext();
		i++;
	    }
	    LNode newNode = new LNode(value);
	    newNode.setNext(current.getNext());
	    current.setNext(newNode);
	}
	size++;
	return true;
    }
    public int indexOf(int value){
	LNode current = head;
	int i = 0;
	while(i<size()){
	    if(current.getValue() == value){
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
    public static void main(String[] args){
	MyLinkedList l1 = new MyLinkedList();
	/*	l1.add(3);
	System.out.println(l1);
       	l1.add(4);
	System.out.println(l1);
	l1.add(5);
	System.out.println(l1);
     	System.out.println("size is " + l1.size());
	l1.remove(1);
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
	*/}
}
