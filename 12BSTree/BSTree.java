public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	public void setData(T val){
	    data = val;
	}
	public void setLeft(Node newL){
	    left = newL;
	}
	public void setRight(Node newR){
	    right = newR;
	}
	public T getData(){
	    return data;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}

	// set/get: data/left/right
	//real methods here
	public int height(){ 
	    return 0;
	}
	public void add(T value){
	    if(T == null){
		setData(value);
	    }
	    else if(left.getData() == null){
		    left.setData(value);
	    }
	    else if(right.getData() == null){
		right.setData(value);
	    }

	public String toString(){
	    String retString;
	    retString += data;
	    if(left == null){
		retString += "_";
	    }
	    if(right == null){
		retString += "_";
	    }
	    if(left==null && right==null){
		return retString;
	    }
	    return left.toString() + right.toString();
	}
	public boolean contains(T value){
	    return false;
	}
    
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	if (root == null){
	    root.setData(value);
	}
	else if(root.getData().comparesTo(value()) == -1){
 
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
}
