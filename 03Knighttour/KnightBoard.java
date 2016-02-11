public class KnightBoard{
    public int numMove=1;
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
		System.out.print(" " + board[i][index] + " ");
	    }
	    System.out.print("\n");
	}
    }
    public void move(int row, int col,int lroffset,int udoffset){
	//needs 8 recursive calls
        board[row+udoffset][col+lroffset] = numMove;
    }
    public solveH(){
	boolean tried = false;
	
    public solve(){
    }
