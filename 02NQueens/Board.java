public class Board{
    private int[][] board; 
    public Board(int side){
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }

    public Board(){
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
    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    System.out.println("cannot place Queen there");
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

	System.out.println("Queen placed!");
	return true;
    }
    public boolean canPlace(int row, int col){ //adds the queen if canPlace
	addQueen(row, col);
	int i = 0;
	while(i<board.length){
	    if(board[i][col+1] == 0){
		return true;
	    }
	}
	return false;
    }
	
    public boolean rmvQueen(int row, int col){
	if(board[row][col] != 1){
	    System.out.println("no Queen there to remove");
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
	System.out.println("Queen removed!");
	return true;
    }
    
    public boolean solveH(int col){
	int row = 0;
	int lastrow = 0;
	while(col<board.length){
	    if(col == board.length -1){
		System.out.println("SOLVED!");
		return true;
	    }
	    while(row<board.length){
		if(canPlace(row,col)){
		    lastrow = row;
		    return solveH(col+1);
		}
		if(row==board.length-1){
		    rmvQueen(lastrow,col-1);
		    System.out.println("backtracked");
		    return solveH(col-1);
		}
		row++;
	    }
	    col++;
	}
	System.out.println("NO SOLUTION!");
	return false;
    }	
    public boolean solve(){
	return solveH(0);
    }
}
