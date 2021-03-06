import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
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
    
    private char[][] maze;
    private int[] solution;
    private int numSteps;
    private int startRow,startCol;
    private int numRow, numCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false


   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/   
	return solution;   
    }    

    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/   
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   

    //initialize the frontier as a stack and call solve
   
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/ 
 	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of 
      elements on the frontier.
    When animate is true, print the maze each time you 
    process a new node.
    **/
   
    public boolean solve(){  
        /** IMPLEMENT THIS **/
	//add start
	numSteps = 0;
	placesToGo.add(new Node(startRow, startCol,null));
	while(placesToGo.hasNext()){
	    Node next = placesToGo.next();
	    Node[] neighbors = getNsetNeighbors(next);
	    //System.out.println("Found neighbors!");
	    for(Node n : neighbors){
		//check if it's the end
		if(checkEnd(n)){
		    getNumSteps(n);  
		    makeSolution(n);
		    System.out.println("FOUND END");
		    return true;
		}
	        process(n);
		maze[n.getX()][n.getY()] = '.';
	    }
	}
	  
	return false; // has no 'E'
    }
    public String getSRSC(){
	return "" + startRow + ", " + startCol;
    }
    public int getNumSteps(Node n){ //from node n(End node)
	int i = 0;
	Node current = n; //so you dont really change n until later in makeSol
	while(current.getPrev() != null){
	    i++;
	    current = current.getPrev();
	}
	i++;
	numSteps = i;
	System.out.println("numSteps: " + numSteps);
	return numSteps;
    }
    public void makeSolution(Node n){
	solution = new int[numSteps*2];
	int i = solution.length-1;
	while(n.getPrev()!= null){
	    solution[i] = n.getY();
	    solution[i-1] = n.getX();
	    i-=2;
	    n = n.getPrev();
	}
	solution[i] = n.getY(); //should be equal to startRow
	solution[i-1] = n.getX(); //should be equal to startCol
	System.out.println("i/sol.length" + i + "/" + solution.length);
    }
    public String printSolution(){
	String retString = "[";
	for(int i = 0;i<solution.length-1;i++){
	    retString += solution[i] + ",";
	}
	retString += solution[solution.length-1] + "]";
	return retString;
    }
	
    public String process(Node n){ //next is already in bounds, check if each of neighbors is inbounds and then decide whether to add to PTG or not
	if(validSpot(n.getX(), n.getY())){
	    placesToGo.add(n);
	    return "neighbor is goodto go";
	}
	else{
	    return "this neighbor node is NOT VALID";
	}
	// not sure what to do here
    }
    public boolean checkEnd(Node n){
	int x = n.getX();
	int y = n.getY();
	return maze[x][y] == 'E';
    }
    public Node[] getNsetNeighbors(Node n){
	int x = n.getX();
	int y = n.getY();
	Node[] neighbors = new Node[4];
	neighbors[0] = new Node(x-1,y,n);
	neighbors[1] = new Node(x+1,y,n); 
	neighbors[2] = new Node(x,y+1,n); 
	neighbors[3] = new Node(x,y-1,n);
	return neighbors;
    }
    public boolean validSpot(int x, int y){
	if(x >= numRow || x < 0){
	    return false;
	}
	if(y >= numCol || x < 0){
	    return false;
	}
	if(maze[x][y] == '#'){
	    return false;
	}
	if(maze[x][y] == '.'){
	    return false;
	}
	return true;
    }

   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/
	animate = b;
    }
    public BetterMaze(String filename){
    animate = false;
    int maxc = 0;
    int maxr = 0;
    startRow = -1;
    startCol = -1;
    //read the whole maze into a single string first
    String ans = "";
    try{
        Scanner in = new Scanner(new File(filename));
 
        //keep reading next line
        while(in.hasNext()){
        String line = in.nextLine();
        if(maxr == 0){
            //calculate width of the maze
            maxc = line.length();
        }
        //every new line add 1 to the height of the maze
        maxr++;
        ans += line;
        }
    }
    catch(Exception e){
        System.out.println("File: " + filename + " could not be opened.");
        e.printStackTrace();
        System.exit(0);
    }
    System.out.println(maxr+" "+maxc);
    maze = new char[maxr][maxc];
    numRow = maxr;
    numCol = maxc;
    for(int i = 0; i < ans.length(); i++){
        char c = ans.charAt(i);
        maze[i / maxc][i % maxc] = c;
        if(c == 'S'){//found Start for you
	    startCol = i % maxc; 
	    startRow = i / maxc;
        }
    }
    }
 
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
    }
 
    public void clearTerminal(){
    System.out.println(CLEAR_SCREEN);
    }
 
    public void wait(int millis){
    try {
        Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
    }
 
 
    public String toString(){
    int maxr = maze.length;
    int maxc = maze[0].length;
    String ans = "";
    if(animate){
        ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
    }
    for(int i = 0; i < maxc * maxr; i++){
        if(i % maxc == 0 && i != 0){
        ans += color(37,40) + "\n";
        }
        char c =  maze[i / maxc][i % maxc];
        if(c == '#'){
        ans += color(38,47)+c;
        }else{
        ans += color(33,40)+c;
        }
    }
    //nice animation string
    if(animate){
        return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
    }else{
        return ans + color(37,40) + "\n";
    }
    }
 
}
   

