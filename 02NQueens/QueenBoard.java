public class QueenBoard{
    private int[][] board; 
    public QueenBoard(int side){
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }

    public QueenBoard(){
	board = new int[4][4];
	for(int i = 0;i<4;i++){
	    for(int index = 0;index<4;index++){
		board[i][index] = 0;
	    }
	}
    }
    public void printBoard(){
	for(int i = 0;i<board.length;i++){
	    for(int index = 0;index<board[0].length;index++){
		System.out.print(" " + board[i][index] + " ");
	    }
	    System.out.print("\n");
	}
    }

    public void printSolution(){
	for(int i = 0;i<board.length;i++){
	    for(int index = 0;index<board.length;index++){
		if(board[i][index] == 1){
		    System.out.print(" Q ");
		}
		else{
		    System.out.print(" _ ");
		}
	    }
	    System.out.print("\n");
	}
    }
    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    //	    System.out.println("cannot place Queen there");
	    return false;
	}//that way it cannot add a queen on a negative space
	board[row][col] = 1; 
	int offset = 1; //can keep on increasing, useful for diagonals
        while(col + offset < board.length){
	    board[row][col+offset] -= 1; //don't need to subtract downwards
	    if(row+offset < board.length){
		board[row+offset][col+offset] -= 1;
	    }
	    if(row-offset >= 0){
		board[row-offset][col+offset] -= 1; //NOT col-offset
	    }
	    offset ++;
	}

	//System.out.println("Queen placed!");
	return true;
    }
    public boolean canPlace(int row, int col){ //adds the queen if canPlace
	addQueen(row, col);
	int i = 0;
	while(i<board.length){
	    if(board[i][col+1] != 0){
		return false;
	    }
	}
	return true;
    }
	
    public boolean rmvQueen(int row, int col){
	if(board[row][col] < 1){
	    //  System.out.println("no Queen there to remove");
	    return false;
	}
	board[row][col] = 0; //returning it back to normal
	int offset = 1;
        while(col + offset < board.length){
	    board[row][col+offset] += 1; //don't need to add downwards
	    if(row+offset < board.length){
		board[row+offset][col+offset] += 1;
	    }
	    if(row-offset >= 0){
		board[row-offset][col+offset] += 1; //NOT col-offset
	    }
	    offset ++;
	}
	//System.out.println("Queen removed!");
	return true;
    }
    
    public boolean solveH(int col){
	if(col >= board.length){
	    return true;
	}
	for(int i =0;i<board.length;i++){
	    if(addQueen(i,col) && solveH(col+1)){
		return true;
	    }
	    else{
		rmvQueen(i,col);
	    }
	}
	return false;
    }	
    public boolean solve(){
	return solveH(0);
    }
}
