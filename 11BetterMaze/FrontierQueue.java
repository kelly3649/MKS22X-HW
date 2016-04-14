public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    MyQueue q = new MyQueue<T>();

    public void add(T element){
	q.enqueue(element);
    }	
    public T next(){
	if(hasNext()){
	    return (T)q.dequeue(); //NOT peek()
	}
	return null; //hopefull will never happen
    }
    public boolean hasNext(){
	return !(q.isEmpty());
    }
    public static void main(String[]args){
	FrontierQueue<Integer> f1 = new FrontierQueue();
	f1.enqueue(3);
	System.out.println(f1.hasNext());
	System.out.println(f1.next());
    }
}
