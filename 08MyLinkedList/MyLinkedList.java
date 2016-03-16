public class MyLinkedList{
    LNode start;
    int size;

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
    public MyLinkedList(){
	start = null;
	size = 0;
    }
    public void add(int val){
	int i = 0;
	LNode current = start;
	if(size==0){
	    start=new LNode(val);
	}
	else{
	    LNode current = start;
	    while(i<size){
		current = current.getNext();
		i++;
	    }

	    current = new LNode(val);
	    start = current;
	}
	size++;
    }
    public int get(int index){
	int i = 0;
	while(i<index){
	    start = start.getNext();
	    i++;
	}
	return start.getValue();
    }
    public int set(int index, int newValue){
	int i = 0;
	while(i<index){
	    start=start.getNext();
	    i++;
	}
	int copy = start.getValue();
	start.setValue(newValue);
	return copy;
    }
    public int size(){
	return size;
    }
    public int remove(int index){
	int i = 0;
	while(i<index-1){
	    start = start.getNext();
	    i++;
	}
	int copy = start.getNext().getValue();
	start.setNext(start.getNext().getNext());
	size--;
	return copy;
    }
    
    public String toString(){
	String retString = "[";
        int i = size;
	while(i>0){
	    retString += start.getValue() +",";
	    start = start.getNext();
	    i--;
	}
	//retString += start.getValue() + "]";
	return retString; 
    }   
    public static void main(String[] args){
	MyLinkedList l1 = new MyLinkedList();
	l1.add(3);
	System.out.println(l1);
       	l1.add(4);
	System.out.println(l1);
	l1.add(5);

	/*	System.out.println("size is " + l1.size());
	l1.remove(1);
	System.out.println(l1);
	System.out.println("size is " + l1.size());
	System.out.println("element/index " + l1.get(1) + "/1");
	l1.set(1,13);
	System.out.println("element/index " + l1.get(1) + "/1");
	*/  }
}
