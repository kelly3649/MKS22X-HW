import java.util.*;

public class RunningMedian{
    private MyHeap<Integer> HLeft;
    private MyHeap<Integer> HRight;
    private int size;

    //Create an empty running median set.
    public RunningMedian(){
	HLeft = new MyHeap<Integer>(true); //bc is max heap
	HRight = new MyHeap<Integer>(false); //bc is min heap
	size = 0;
    }
    //When empty: throws new NoSuchElementException()
	//Returns the median value
    public double getMedian(){
	if(HLeft.getSize() + HRight.getSize() == 0){
	    throw new NoSuchElementException();
	}
	//check two heaps, if diff sizes: at most one apart, then median is in larger;
	else{
	    if(HLeft.getSize() > HRight.getSize()){
		return HLeft.peek();
	    }
	    if(HRight.getSize() > HLeft.getSize()){
		return HRight.peek();
	    }
	    else{ //both sizes are equal
		return (HLeft.peek() + HRight.peek())/2.0;
	    }
	}
    }
    public MyHeap getLeft(){
	return HLeft;
    }
    public MyHeap getRight(){
	return HRight;
    }
    

    //add to the "SmallValue" heap if  x < median, 
    //add to the "BigValue" heap otherwise. 
    //balance the two heaps so that their size differ by no more than 1.    
    public void add(Integer x){
	if(HLeft.getSize() == 0 && HRight.getSize() == 0){
	    HLeft.add(x);
	}
	if(x > getMedian()){
	    HLeft.add(x);
	}
	else{
	    HRight.add(x);
	}
	size++;
	//check if unbalanced
	if(HLeft.getSize() > HRight.getSize() + 1){
	    int temp = HLeft.peek();
	    HLeft.remove();
	    HRight.add(temp);
	}
	else if(HRight.getSize() > HLeft.getSize() + 1){
	    int temp = HRight.peek();
	    HRight.remove();
	    HLeft.add(temp);
	}
    }
    //first add, then check if unbalanced, then move
    public String toString(){
	String retString = "";
	retString += "left:" + HLeft.toString() + " right:" + HRight.toString();
	return retString;
    } 
}
