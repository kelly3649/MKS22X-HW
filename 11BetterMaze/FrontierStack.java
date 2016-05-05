public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    MyStack s = new MyStack<T>();
    
    public void add(T element){
	s.push(element);
    }

    @SuppressWarnings("unchecked")
    public T next(){
	if(hasNext()){
	    return (T)s.pop(); //not peek()
	}
	return null;
    }
    public boolean hasNext(){
	return !(s.isEmpty());
    }
    public static void main(String[]args){
	FrontierStack<Integer> f1 = new FrontierStack<Integer>();
	f1.add(2);
	System.out.println(f1.hasNext());
	System.out.println(f1.next());
    }	
}
