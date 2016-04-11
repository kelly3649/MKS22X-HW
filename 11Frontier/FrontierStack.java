public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    MyStack s = new MyStack<T>();
    
    public void add(T element){
	s.push(element);
    }
    public T next(){
	if(hasNext()){
	    return s.peek();
	}
    }
    public boolean hasNext(){
	return !(s.isEmpty());
    }
}
