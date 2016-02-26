public class KnightBoard{
    public int[][] board;
    
    public KnightBoard(int side){
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }
    public KnightBoard(int row, int col){
	board = new int[row][col];
	for(int i = 0;i<row;i++){
	    for(int index = 0;index<col;index++){
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
		if(board.length*board[0].length >= 10 && board[i][index] < 10){
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
    public boolean solveH(int row, int col,int numMove){ //needs 3 parameters
	//	printBoard();
	//check if on board
	if(row<0 || row>=board.length || col<0 || col>=board[0].length){
	    //	    System.out.println("OUT OF BOUNDS");
	    return false;
	}//if not a zero, cannot place there
	if(board[row][col] != 0){
	    return false;
	}
	if(numMove == board.length*board[0].length){
	    board[row][col] = numMove;
	    return true;
	}
	//else just place it down!
	board[row][col] = numMove;
	//if last move, you've solved
	
	
	if(solveH(row-1,col-2,numMove+1)){
		return true;
	}
	if(solveH(row-1,col+2,numMove+1)){
	    return true;
	}
	if(solveH(row-2, col-1,numMove+1)){
	    return true;
	}  
	if(solveH(row-2,col+1,numMove+1)){
	    return true;
	}
	if(solveH(row+1,col-2,numMove+1)){
	    return true;
	}
	if(solveH(row+1,col+2,numMove+1)){
		return true;
	}
	if(solveH(row+2,col-1,numMove+1)){
	    return true;
	}
	if(solveH(row+2,col+1,numMove+1)){
	    return true;
	}
	board[row][col] = 0;
	return false;
    }

	   		
	    
    public boolean solve(){
	return solveH(0,0,1);
		    
    }
    public static void main(String[]args){
	KnightBoard b1 =  new KnightBoard(4);
	System.out.println(b1.solve());
	b1.printBoard();
        KnightBoard b2 =  new KnightBoard(2);
	System.out.println(b2.solve());
	b2.printBoard();
	KnightBoard b3 =  new KnightBoard(1);
	System.out.println(b3.solve());
	b3.printBoard();
	KnightBoard b4 =  new KnightBoard(3,7);
	System.out.println(b4.solve());
	b4.printBoard();
	
    }
}
