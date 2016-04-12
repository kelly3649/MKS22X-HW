public class BetterMaze{
    private char[][] maze;
    private int[] solution;
    private int      startRow,startCol;
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
	solve();
    }   

   //initialize the frontier as a stack and call solve
   
public boolean solveDFS(){  
        /** IMPLEMENT THIS **/ 
 	placesToGo = new FrontierStack<Node>();
	solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of 
      elements on the frontier.
    When animate is true, print the maze each time you 
    process a new node.
    **/
    public void findStart(){
	for(int i = 0;i<maze.length;i++){
	    for(int index = 0;index<maze[0].length;i++){
		if(maze[i][index] == 'S'){
		    startRow = i;
		    startCol = index;
		}
	    }
	}
    public boolean solve(){  
        /** IMPLEMENT THIS **/
	findStart();
	placesToGo.add(new Node(startRow, startCol,null));
	
	while(placesToGo.hasNext()){
	    Node next = placesToGo.next();
	   
	}

    }    
    public Node[] getNeighbors(Node n){
	Node[] neighbors = new Node[4];
	if(!outOfBounds(x-1,
	neighbors[0] = new Node(x-1,y,n);
	neighbors[1] = new Node(x+1,y,n); 
	neighbors[2] = new Node(x,y+1,n); 
	neighbors[3] = new Node(x,y-1,n);
    }
	   public boolean outOfBounds(int x, int y){

   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/ }    



}

