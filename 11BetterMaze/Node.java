public class Node{
    int x,y;
    Node prev;

    public Node(int X, int Y, Node preV){
	x = X;
	y = Y;
	prev = preV;
    }
    public Node getPrev(){
	return prev;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
}
