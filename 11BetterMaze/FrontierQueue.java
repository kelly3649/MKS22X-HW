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
	    return q.dequeue(); //NOT peek()
	}
    }
    public boolean hasNext(){
	return !(q.isEmpty());
    }

}
