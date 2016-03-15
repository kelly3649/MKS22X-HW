public class MyLinkedList{
    LNode start;
    int size;

    private class LNode{
	int value;
	LNode next;


	public LNode(int val){
	    value = val;
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
	while(start.getValue() != null){
	    start = start.getNext();
	}
	start.setValue(val);
    }
public String toString(){
	String retString = "[";
        int i = size;
	while(i>0){
	    retString += start.getValue() +",";
	    start = start.getNext();
	    i--;
	}
	retString += "]";
	return retString; 
    }   
    public static void main(String[args]){
	MyLinkedList l1 = new MyLinkedList();
	l1.add(3);
	System.out.println(MyLinkedList()
