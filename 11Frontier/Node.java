public class Node{
    int ID;
    Node prev;

    public Node(int id, Node preV){
	ID = id;
	prev = preV;
    }
    public Node getPrev(){
	return prev;
    }
    public int getValue(){
	return ID;
    }
}
