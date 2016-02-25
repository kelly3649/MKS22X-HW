public class KnightBoard{
    public int numMove=2;
    public int nextRow,nextCol;
    public int[][] board;
    public KnightBoard(int side){
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }

    public KnightBoard(){
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
		if(board.length*board[0].length >= 10){
		System.out.print(" _" + board[i][index] + " ");
		}
		else{
		System.out.print(" " + board[i][index] + " ");
		}
	    }
	    System.out.print("\n");
	}
	System.out.print("\n");
    }
	//needs 8 recursive calls
	//returns true if one of the eight moves works
	//returns false if all cannot be done
    public boolean solveH(int row, int col){ //needs 3 parameters
	printBoard();
	//check if on board
	if(row<0 || row>=board.length || col<0 || col<=board.length){
	    return false;
	}
	if(numMove == board.length*board.length + 1){
	    return true;
	}
	if(numMove == 1){//since numMove keeps on decr, if it reaches 1, that means there are no ways for it to move to 2
	    return false;
	}
	    		if(col >= 2 && board[row-1][col-2] == 0){
		    board[row-1][col-2] = numMove;
		    numMove++;
		    nextRow = row-1;
		    nextCol = col-2;
		    solveH(nextRow,nextCol);
		}


		if(col<board.length-2 && board[row-1][col+2] == 0){
		    board[row-1][col+2] = numMove;
		    numMove++;
		    nextRow = row-1;
		    nextCol = col+2;
		    solveH(nextRow,nextCol);
		}
		if(row > 1){
		    if(col >= 1 && board[row-2][col-1] == 0){
			board[row-2][col-2] = numMove;
			numMove++;
			nextRow = row-2;
			nextCol = col-1;
			solveH(nextRow,nextCol);
		    }
		    if(col < board.length-1 && board[row-2][col+1] == 0){
			board[row-2][col+1] = numMove;
			numMove++;
			nextRow = row-2;
			nextCol = col+1;
			solveH(nextRow,nextCol);
		    }
		}
	    }
	    if(row<board.length-1){
		if(col >= 2 && board[row+1][col-2] == 0){
		    board[row+1][col-2] = numMove;
		    numMove++;
		    nextRow = row+1;
		    nextCol = col-2;
		    solveH(nextRow,nextCol);
		}
		if(col<board.length-2 && board[row+1][col+2] == 0){
		    board[row+1][col+2] = numMove;
		    numMove++;
		    nextRow = row+1;
		    nextCol = col+2;
		    solveH(nextRow,nextCol);
		}
		if(row<board.length-2){
		    if(col >= 1 && board[row+2][col-1] == 0){
			board[row+2][col-1] = numMove;
			numMove++;
			nextRow = row+2;
			nextCol = col-1;
			solveH(nextRow,nextCol);
		    }
		    if(col < board.length-1 && board[row+2][col+1] == 0){
			board[row+2][col+1] = numMove;
			numMove++;
			nextRow = row+2;
			nextCol = col+1;
			solveH(nextRow,nextCol);
		    }
		}
	    }
	    board[row][col] = 0;
	    numMove--;
	   }
	return false;
	
    }

	   		
	    
    public boolean solve(){
	board[0][0] = 1; //start at top left corner
	return solveH(0,0);
		    
    }
    public static void main(String[]args){
	KnightBoard b1 =  new KnightBoard(4);
	b1.solve();
	b1.printBoard();
    }
}
