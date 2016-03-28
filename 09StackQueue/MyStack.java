import java.util.*;
public class MyStack<T>{
    /**
     * Adds the given item to the top(head) of the stack. 
     */
    MyLinkedList<T> m = new MyLinkedList<T>();
    public void push(T item){
        m.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop(){
	if(m.size() == 0){
	    throw new NoSuchElementException();
	}
	T answer = m.remove(0);
	return answer;
    }
    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
	if(m.size() == 0){
	    throw new NoSuchElementException();
	}
	T answer = m.get(0);
	return answer;
    }
    /**
     * Returns the number of items currently in the stack.
     */
    int size(){
	return m.size();
    }
    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty(){
	return size() == 0;
    }

    public static void main(String[]args){
	MyStack<Integer> m1 = new MyStack<Integer>();
	/*System.out.println(m1.isEmpty());
	m1.push(123);
	System.out.println(m1.size());
	m1.push(4);
	m1.push(-134);
	System.out.println(m1.peek());
	System.out.println(m1.pop());
	System.out.println(m1.isEmpty());
	*/
    }
}
