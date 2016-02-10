public class Board{
    private int side;
    private int[][] board; 
    public Board(int n){
	side = n;
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }

    public Board(){
	side = 4;
	board = new int[side][side];
	for(int i = 0;i<side;i++){
	    for(int index = 0;index<side;index++){
		board[i][index] = 0;
	    }
	}
    }
    public void printBoard(){
	for(int i = 0;i<board.length;i++){
	    for(int index = 0;index<board[0].length;index++){
		System.out.print(board[i][index] + " ");
	    }
	    System.out.print("\n");
	}
    }
    public void addQueen(int row, int col){
	board[row][col] = 1;
	for(int i = 0;i<board.length;i++){
	    board[i][col] -= 1;
	    for(int index= 0;index<board[0].length;index++){
		board[row][index] -= 1;
		board[row+i+1][col+index+1] -= 1;
		board[row-i-1][col+index+1] -= 1;
	    }
	}
	
    }
    //public void rmvQueen(){
    //}
}
