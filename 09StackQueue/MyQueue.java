import java.util.*;
public class MyQueue<T>{
    /**
     * Adds the given item to the rear(tail) of the queue. 
     */
    MyLinkedList<T> m = new MyLinkedList<T>();
    void enqueue(T item){
	m.add(item);
    }

    /**
     * Removes the front(head) item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue(){
	if(m.size() == 0){
	    throw new NoSuchElementException();
	}
	T answer = m.remove(0);
	return answer;
    }

    /**
     * Returns the front(head) item from the queue without popping it.
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
     * Returns the number of items currently in the queue.
     */
    int size(){
	return m.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty(){
	return size() == 0;
    }
    public static void main(String[]args){
	MyQueue<String> m1 = new MyQueue<String>();
	/*
	System.out.println(m1.isEmpty());
	System.out.println(m1.size());
	m1.enqueue("I");
	System.out.println(m1.size());
	m1.enqueue("Kelly");
	System.out.println(m1.dequeue());
	System.out.println(m1.size());
	m1.enqueue("likes");
	System.out.println(m1.peek());
	m1.enqueue("BROWNIES<3");
	System.out.println(m1.size());
	System.out.println(m1.isEmpty());
	*/}
}
