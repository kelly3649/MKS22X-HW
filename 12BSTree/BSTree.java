public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	public Node(T val){
	    data = val;
	}
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
	    return 1;
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
    public getHeight(){ //your height is one, you keep adding 1 to your children until both children are null
	//keep track of height.
	//call the root's methods
	//check for empty first!
	if(root.getLeft() == null && root.getRight() == null){
	    return;
	}
        if(root.getLeft() == null){
	    return 1 + root.getHeight();
	}
    }

    public void add(T value){
	//check for empty before you do things with root.
	if (root == null){
	    root = new Node(value);
	}
	else{
	    add(root,value);
	}

    }
    public void add(Node where, T d){
	if (d.compareTo(where.getData()) < 0){
	    if(where.getLeft() == null){
		where.setLeft(new Node(d));
	    }
	    else{
		add(where.getLeft(),d);
	    }
	}
	else{
	    if(where.getRight() == null){
		 where.setRight(new Node(d));
	    }
	    else{
	        add(where.getLeft(),d);
	    }
	}
    }
    public String toString(){
	if(root != null){
	//check for empty before you do things with root.
	    return root.toString();
	}
	else{
	    return "Empty Tree :(";
	}
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
    public static void main(String[] args){
	BSTree b1 = new BSTree();
	b1.add(3);
	b1.add(5);
	System.out.println(b1);
    }
}
